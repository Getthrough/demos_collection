package com.github.getthrough.temp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author getthrough
 * @date 2020/3/2
 */
public class Temp1 {

    public void SocketChannel() throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("127.0.0.1", 8000));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = sc.read(buffer);

    }

    public void ServerSocketChannel() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.socket().bind(new InetSocketAddress(8000));
        ssc.configureBlocking(false);

        while (true) {

            SocketChannel socketChannel = ssc.accept();
            if (socketChannel != null) {
                // do something
            }

        }

    }

}
