package org.Test.Netty_A;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.concurrent.EventExecutorGroup;


/**
 * Created by weixin on 17-8-10.
 */
public class InBoundHandler1 extends ChannelInboundHandlerAdapter {
//    private static Logger logger=Logger.getLogger(InBoundHandler1.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        System.out.println("InBoundHandler1.ChannelRead:ctx:"+ctx);
        ByteBuf result=(ByteBuf)msg;
        byte[] result1=new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr=new String(result1);
        System.out.println("Client said:"+resultStr);
        result.release();
        ctx.write(msg);
        ctx.writeAndFlush(msg);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        System.out.println("InBoundHandler1.channelReadComplete");
        ctx.flush();

    }
}
