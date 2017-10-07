package org.Test.Netty_A;

import io.netty.channel.*;
import io.netty.util.concurrent.EventExecutorGroup;



/**
 * Created by weixin on 17-8-10.
 */
public class OutboundHandler2 extends ChannelHandlerAdapter {
//    private static Logger logger=Logger.getLogger(OutboundHandler2.class);
    @Override
    public void write(ChannelHandlerContext ctx,Object msg,ChannelPromise promise) throws Exception {
        System.out.println("OutBoundHandler2.write");
        super.write(ctx,msg,promise);
        System.out.println(msg+"11020202");
    }
}
