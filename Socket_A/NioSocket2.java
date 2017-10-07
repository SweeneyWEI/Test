package org.Test.Socket_A;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by weixin on 17-8-8.
 */
public class NioSocket2 {
    static String string1;
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
                        string1 = str;
                    } catch (IOException e) {
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
//                        socketChannel.register(selector,SelectionKey.OP_WRITE);

                    }
                    selector.selectedKeys().remove(sk);
                    sk.interestOps(SelectionKey.OP_WRITE);
                    //--------------------------------------------------------------
                    String[] Path = string1.split("GET ");
                    String[] Path2 = Path[1].split(" HTTP");
                    string1 = Path2[0];
                    System.out.println(string1);
                    //--------------------------------------------------------------

                } else if (sk.isWritable()) {
                    SocketChannel socketChannel=(SocketChannel)sk.channel();
                    //--------------------------------------------------------------
                    //--------------------------------------------------------------
                    File f = new File(string1);

                    FileChannel file = new FileInputStream(f).getChannel();

                    MappedByteBuffer buff = file.map(FileChannel.MapMode.READ_ONLY, 0, f.length());

                    ByteBuffer buffer = charset.encode("HTTP/1.1 200 OK \r\nContent-Type:text/html;charset:utf-8\r\n" +
                            "Content-Length:" + f.length() + "\r\n" + "\r\n");
                    socketChannel.write(buffer);
                    //buff.flip();
                    socketChannel.write(buff);
                    file.close();
                    selector.selectedKeys().remove(sk);
                    sk.interestOps(SelectionKey.OP_READ);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NioSocket2().init();

    }
}
