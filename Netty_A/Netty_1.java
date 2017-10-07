package org.Test.Netty_A;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by weixin on 17-8-9.
 */
public class Netty_1 {
    public static void main(String[] args) throws InterruptedException {
        Netty_1 server = new Netty_1();
        server.start(8000);
    }

    public void start(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).
                    childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new OutboundHandler1());
                            channel.pipeline().addLast(new OutboundHandler2());
                            channel.pipeline().addLast(new InBoundHandler1());
                            channel.pipeline().addLast(new InBoundHandler2());

                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//            System.out.println("1256787985613");
            ChannelFuture f = b.bind(8080).sync();

            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}


