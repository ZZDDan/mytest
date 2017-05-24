package com.rxx.socketdemo.socket.aio.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @Title      :WriteHander
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月15日 下午4:27:43
 */
public class WriteHander implements CompletionHandler<Integer, ByteBuffer> {

    AsynchronousSocketChannel socketChannel;
    CountDownLatch latch;
    
    public WriteHander(AsynchronousSocketChannel socketChannel, CountDownLatch latch) {
        this.socketChannel = socketChannel;
        this.latch = latch;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if(buffer.hasRemaining()){// 完成全部数据的写入
            socketChannel.write(buffer, buffer, this);
        }else{// 完成数据的读取
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(readBuffer, readBuffer, new ReadHander(socketChannel, latch));
        }
        
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        System.out.println("数据发送失败");
        try {
            socketChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
