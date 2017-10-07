package org.Test.Netty_A.netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.*;


/**
 * Created by weixin on 17-8-27.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
//    private static Logger logger=Logger.getLogger(NettyClientHandler.class);



    int count=0;
    @Override
    // 当连接建立的时候向服务端发送消息 ，channelActive 事件当连接建立的时候会触发
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

//        logger.info("HelloClientIntHandler.channelActive");//w
        for (int i = 0; i < 100; i++) {
            count++;
            String msg = "Are you ok?"+" "+count+"\n";
            ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
            encoded.writeBytes(msg.getBytes());
            ctx.write(encoded);
            ctx.flush();
        }
    }

//    @Override
//    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//        String string="hello word";
//        ByteBuf byteBuf=ctx.alloc().buffer(4*string.length());
//        byteBuf.writeBytes(string.getBytes());
//        ctx.write(byteBuf);
//        ctx.flush();
//    }
}
