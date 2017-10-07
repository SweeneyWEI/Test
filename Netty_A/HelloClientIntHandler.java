package org.Test.Netty_A;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by weixin on 17-8-10.
 */
public class HelloClientIntHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("HelloClientIntHandler.channelRead");
        ByteBuf result=(ByteBuf)msg;
        byte[] result1=new byte[result.readableBytes()];
        result.readBytes(result1);
        result.release();
        ctx.close();
        System.out.println("服务端说："+new String(result1));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("HelloClientInhandler.channelActive");
        String msg="/home/weixin/software/html/hello.html";
        ByteBuf byteBuf=ctx.alloc().buffer(4*msg.length());
        byteBuf.writeBytes(msg.getBytes());
        ctx.write(byteBuf);
        ctx.flush();
    }
}
