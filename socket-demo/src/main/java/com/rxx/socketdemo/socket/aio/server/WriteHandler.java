package com.rxx.socketdemo.socket.aio.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Title      :WriteHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月12日 下午3:01:04
 */
public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;
    public WriteHandler(AsynchronousSocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if(buffer.hasRemaining()){// 如果没有发送完，就继续发送直到完成  
            socketChannel.write(buffer, buffer, this);
        }else{
            //异步读  第三个参数为接收消息回调的业务Handler
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(readBuffer, readBuffer, new ReadHandler(socketChannel));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
