package com.github.getthrough.netty.simple.client.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 使用有长度字段指示内容长度的解码器
 *
 * @author getthrough
 * @date 2020/3/19
 */
public class SimpleLengthFieldFrameDecoder extends LengthFieldBasedFrameDecoder {
    public SimpleLengthFieldFrameDecoder(int lengthFieldLength) {
        super(Integer.MAX_VALUE, 0, lengthFieldLength, 0, lengthFieldLength);
    }
}
