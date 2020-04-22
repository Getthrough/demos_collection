package com.github.getthrough.netty.simple.handler.in_bound_handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author getthrough
 * @date 2020/3/19
 */
public class InboundHandler1 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InboundHandler1 channelRead enter");

        String data = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);
        System.out.println("InboundHandler1 receive data : " + data);

        ctx.fireChannelRead(Unpooled.copiedBuffer("[InboundHandler1] " + data, CharsetUtil.UTF_8));

        // ctx.write(msg);

        System.out.println("InboundHandler1 channelRead exit");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
