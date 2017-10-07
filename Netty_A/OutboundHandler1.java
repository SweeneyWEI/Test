package org.Test.Netty_A;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;



/**
 * Created by weixin on 17-8-9.
 */
public class OutboundHandler1 extends ChannelHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx,Object msg,ChannelPromise promise){
        System.out.println("OutboundHandler1.write");
        String response="i am ok";
        ByteBuf encoded=ctx.alloc().buffer(4*response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }


}
