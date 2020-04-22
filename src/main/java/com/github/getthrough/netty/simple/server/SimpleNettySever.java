package com.github.getthrough.netty.simple.server;

import com.github.getthrough.netty.simple.handler.in_bound_handler.InboundHandler1;
import com.github.getthrough.netty.simple.handler.in_bound_handler.InboundHandler2;
import com.github.getthrough.netty.simple.handler.in_bound_handler.InboundHandler3;
import com.github.getthrough.netty.simple.handler.out_bound_handler.OutBoundHandler1;
import com.github.getthrough.netty.simple.handler.out_bound_handler.OutBoundHandler2;
import com.github.getthrough.netty.simple.handler.out_bound_handler.OutBoundHandler3;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author getthrough
 * @date 2020/3/19
 */
@Slf4j
public class SimpleNettySever {

    public static void main(String[] args) {

        NioEventLoopGroup group = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(group).channel(NioServerSocketChannel.class);

        try {
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.SO_BACKLOG, 10);
            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new OutBoundHandler3());
                    pipeline.addLast(new OutBoundHandler2());
                    pipeline.addLast(new OutBoundHandler1());

                    pipeline.addLast(new InboundHandler1());
                    pipeline.addLast(new InboundHandler2());
                    pipeline.addLast(new InboundHandler3());
                }
            });

            ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess())
                        System.out.println("connect success");
                    else {
                        Throwable cause = future.cause();
                        System.out.println("connect failed, cause : " + cause);
                    }

                }
            });

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

}
