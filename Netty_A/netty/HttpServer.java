package org.Test.Netty_A.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
//import org.apache.log4j.Logger;

/**
 * Created by weixin on 17-8-20.
 */
public class HttpServer {
//    private static Logger logger=Logger.getLogger(PayingController.class);

    public void start(int port) throws InterruptedException {
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();

        try {
        ServerBootstrap b=new ServerBootstrap();
        b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new PayingHandler());
                    }
                }).option(ChannelOption.SO_BACKLOG,128).childOption(ChannelOption.SO_KEEPALIVE,true);

            ChannelFuture f=b.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        HttpServer server=new HttpServer();
        server.start(30000);
    }
}
