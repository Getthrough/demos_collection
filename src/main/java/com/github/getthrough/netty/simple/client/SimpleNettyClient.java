package com.github.getthrough.netty.simple.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * EventLoopGroup 是 EventLoop 的分组，它可以获取到一个或多个 EventLoop 对象。
 * Netty 基于事件驱动模型，使用不同的事件来通知 I/O 状态的改变。EventLoop 负责处理注册
 * 上来的 Channel I/O 操作。一个 EventLoop 在它的声明周期内，只能与一个 Thread 绑定。
 * 由此保证了线程安全。
 *
 * 一个 Channel 在它的生命周期内只能注册到一个 EventLoop
 *
 * @author getthrough
 * @date 2020/3/4
 */
public class SimpleNettyClient {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true);
        try {
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    // pipeline.addLast(new SimpleLengthFieldFrameDecoder(2));
                    // pipeline.addLast(new SimpleFrameEncoder(2));
                    pipeline.addLast(new SimpleNettyClientHandler());
                }
            });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8080).sync();
            System.out.println("client connect success");

            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

}
