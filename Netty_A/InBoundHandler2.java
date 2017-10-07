package org.Test.Netty_A;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.concurrent.EventExecutorGroup;


/**
 * Created by weixin on 17-8-10.
 */
public class InBoundHandler2 extends ChannelHandlerAdapter{
//    private static Logger logger=Logger.getLogger(InBoundHandler2.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        System.out.println("InboundHandler20.channelRead:ctx:"+ctx);
        ByteBuf result=(ByteBuf)msg;
//        System.out.println(msg+"jajaahahahahhha");
        byte[] result1=new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr=new String(result1);
        System.out.println("Client said:"+resultStr);
        result.release();
//        msg="hahahahahhahahahahh";
        ctx.write(msg);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        System.out.println("InboundHandler2.ReadComplete");
        ctx.flush();
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise){
        System.out.println("asdasfdsfassdfadsdf");
    }
}
