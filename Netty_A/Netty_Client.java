package org.Test.Netty_A;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by weixin on 17-8-10.
 */
public class Netty_Client {
    public void connect(String host,int port) throws InterruptedException {
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try {
        Bootstrap b=new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE,true);
        b.handler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new HelloClientIntHandler());
            }
        });

            ChannelFuture f=b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Netty_Client client=new Netty_Client();
        client.connect("127.0.0.1",8080);

    }
}
