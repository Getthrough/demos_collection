package com.github.getthrough.netty.simple.handler.out_bound_handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

/**
 * @author getthrough
 * @date 2020/3/19
 */
public class OutBoundHandler1 extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("OutBoundHandler1 write enter");

        String data = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);
        System.out.println("OutBoundHandler1 to write data : " + data);
        ctx.writeAndFlush(msg);
        // ctx.channel().writeAndFlush(Unpooled.copiedBuffer("在OutboundHandler里测试一下channel().writeAndFlush", CharsetUtil.UTF_8));

        System.out.println("OutBoundHandler1 write exit");
    }
}
