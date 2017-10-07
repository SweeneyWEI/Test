package org.Test.Netty_A.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
//import org.apache.log4j.Logger;


/**
 * Created by weixin on 17-8-25.
 */
public class PayingHandler extends ChannelOutboundHandlerAdapter {
//    private static Logger logger=Logger.getLogger(PayingHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        logger.info("this is channel read");
        ByteBuf result=(ByteBuf)msg;
        byte[] result1=new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr=new String(result1);
        System.out.println("client said:"+resultStr);
        result.release();
    }
}
