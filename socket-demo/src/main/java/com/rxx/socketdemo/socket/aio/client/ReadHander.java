package com.rxx.socketdemo.socket.aio.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

import com.rxx.socketdemo.bean.BaseConstant;

/**
 * @Title      :ReadHander
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月15日 下午4:32:27
 */
public class ReadHander implements CompletionHandler<Integer, ByteBuffer> {

    AsynchronousSocketChannel socketChannel;
    CountDownLatch latch;
    
    public ReadHander(AsynchronousSocketChannel socketChannel, CountDownLatch latch) {
        this.socketChannel = socketChannel;
        this.latch = latch;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        try {
            System.out.println(BaseConstant.CLIENT_ACCEPTED_MSG + new String(bytes, BaseConstant.CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        System.out.println(BaseConstant.READ_MSG_FAIL);
        try {
            socketChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
