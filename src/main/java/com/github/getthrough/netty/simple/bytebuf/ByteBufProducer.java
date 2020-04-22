package com.github.getthrough.netty.simple.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.Objects;

/**
 * netty ByteBuf 生成器
 *
 * @author getthrough
 * @date 2020/4/23
 */
public class ByteBufProducer {

    /**
     * 通过 channel 拿到 ByteBufAllocator 引用，使用 ByteBufAllocator
     * 获取基于 heap 或 direct memory 的 ByteBuf
     *
     * @param channel
     * @return
     */
    public ByteBuf getByteBuf1(Channel channel) {
        Objects.requireNonNull(channel);

        ByteBufAllocator byteBufAllocator = channel.alloc();
        return byteBufAllocator.buffer();
    }

    /**
     * 通过 channel 拿到 ByteBufAllocator 引用，使用 ByteBufAllocator
     * 获取基于 heap 的 ByteBuf
     *
     * @param channel
     * @return
     */
    public ByteBuf getByteBuf2(Channel channel) {
        Objects.requireNonNull(channel);

        ByteBufAllocator byteBufAllocator = channel.alloc();
        return byteBufAllocator.heapBuffer();
    }

    /**
     * 通过 channel 拿到 ByteBufAllocator 引用，使用 ByteBufAllocator
     * 获取基于 direct memory 的 ByteBuf
     *
     * @param channel
     * @return
     */
    public ByteBuf getByteBuf3(Channel channel) {
        Objects.requireNonNull(channel);

        ByteBufAllocator byteBufAllocator = channel.alloc();
        return byteBufAllocator.directBuffer();
    }

    /**
     * 通过 channel 拿到 ByteBufAllocator 引用，使用 ByteBufAllocator
     * 获取基于 heap 或 direct memory 的 组合 ByteBuf
     *
     * @param channel
     * @return
     */
    public ByteBuf getByteBuf4(Channel channel) {
        Objects.requireNonNull(channel);

        ByteBufAllocator byteBufAllocator = channel.alloc();
        return byteBufAllocator.compositeBuffer();
    }

    /**
     * 通过 Channel 获取 ByteBufAllocator
     *
     * @param channel
     * @return
     */
    public ByteBufAllocator getAllocator1(Channel channel) {
        return channel.alloc();
    }

    /**
     * 通过 ChannelHandlerContext 获取 ByteBufAllocator
     *
     * @param ctx
     * @return
     */
    public ByteBufAllocator getAllocator2(ChannelHandlerContext ctx) {
        return ctx.alloc();
    }

}
