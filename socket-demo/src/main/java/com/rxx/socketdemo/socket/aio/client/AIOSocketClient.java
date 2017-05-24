package com.rxx.socketdemo.socket.aio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CountDownLatch;

import com.rxx.socketdemo.concurrent.ThreadPoolTaskExecutor;
import com.rxx.socketdemo.socket.IOSocketClient;

/**
 * @Title      :AIOSocketClient
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月12日 下午3:22:10
 */
public class AIOSocketClient implements IOSocketClient {
    
    public AsynchronousSocketChannel socketChannel;
    public CountDownLatch latch; 

    @Override
    public void start(final String addr, final int port) throws IOException {
        // 创建异步的客户端通道
        socketChannel = AsynchronousSocketChannel.open();
        final AIOSocketClient socketClient = this;
        
        ThreadPoolTaskExecutor.getInstance().execute(new Runnable() {
            
            @Override
            public void run() {
                // 发起异步连接操作，回调参数是 指定的 handler，如果连接成功会执行 handler 的 completed 方法 
                socketChannel.connect(new InetSocketAddress(addr, port), socketClient, new AsyncClientHandler());
                // 创建 CountDownLatch 等待，使线程一直处于运行状态
                latch = new CountDownLatch(1);
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                /*try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }

    /**
     * 向服务器发送消息
     */
    @Override
    public boolean sendMsg(String msg) {
        byte[] bytes = msg.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        socketChannel.write(buffer, buffer, new WriteHander(socketChannel, latch));
        return true;
    }

    @Override
    public void close() {
        if(socketChannel != null){
            try {
                socketChannel.close();
                latch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
            socketChannel = null;
        }
    }

}
