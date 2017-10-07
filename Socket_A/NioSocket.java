package org.Test.Socket_A;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import java.nio.channels.*;
import java.nio.charset.Charset;


/**
 * Created by weixin on 17-8-8.
 */
public class NioSocket {
    private Selector selector=null;
    static final int port=30000;
    private Charset charset=Charset.forName("UTF-8");

    public void init() throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inet = new InetSocketAddress("127.0.0.1", port);
        serverSocketChannel.socket().bind(inet);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {//判断有几个通道就绪了
            for (SelectionKey sk : selector.selectedKeys()) {
                selector.selectedKeys().remove(sk);
                if (sk.isAcceptable()) {
                    selector.selectedKeys().remove(sk);
                    SocketChannel socketChannel1 = serverSocketChannel.accept();
                    socketChannel1.configureBlocking(false);
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                    socketChannel1.register(selector, SelectionKey.OP_READ);


                } else if (sk.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    socketChannel.configureBlocking(false);

                    ByteBuffer bf = ByteBuffer.allocate(1024);
                    String str = "";
                    try {
                        while ((socketChannel.read(bf)) > 0) {
                            bf.flip();
                            str += charset.decode(bf);
                        }
                        System.out.println(str);

                    } catch (IOException e) {
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
//                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                    }
                    selector.selectedKeys().remove(sk);
                    sk.interestOps(SelectionKey.OP_WRITE);
                } else if (sk.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    socketChannel.configureBlocking(false);
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    try {
                        String str = "Helloword";
                        buff.put(str.getBytes());
                        buff.flip();
                        socketChannel.write(buff);
                        System.out.println(str);
                    } catch (IOException e) {
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
                    }
//                    socketChannel.register(selector,SelectionKey.OP_READ);
                    sk.interestOps(SelectionKey.OP_CONNECT);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NioSocket().init();

    }
}
