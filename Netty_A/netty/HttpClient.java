package org.Test.Netty_A.netty;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by weixin on 17-8-27.
 */
public class HttpClient {


    public static void main(String[] args) throws Exception {
        String host="127.0.0.1";
        int port=30000;
        EventLoopGroup workerGroup=new NioEventLoopGroup();

        Bootstrap b=new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE,true);
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                channel.pipeline().addLast(new NettyClientHandler());
            }
        });
        try {
            ChannelFuture future=b.connect(host,port).sync();
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
