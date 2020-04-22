package com.github.getthrough.netty.simple.client.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 基于使用长度字段表示数据长度的编码器
 *
 * @author getthrough
 * @date 2020/3/19
 */
public class SimpleFrameEncoder extends LengthFieldPrepender {
    public SimpleFrameEncoder(int lengthFieldLength) {
        super(lengthFieldLength);
    }
}
