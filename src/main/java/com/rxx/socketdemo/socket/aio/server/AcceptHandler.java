package com.rxx.socketdemo.socket.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

import com.rxx.socketdemo.bean.BaseConstant;

/**
 * @Title      :AcceptHandler
 * @Description:接收客户端链接
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月12日 下午2:31:54
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AIOSocketServer> {

    private AsynchronousServerSocketChannel serverSocketChannel;
    private CountDownLatch latch;

    public AcceptHandler(AsynchronousServerSocketChannel serverSocketChannel, CountDownLatch latch) {
        this.serverSocketChannel = serverSocketChannel;
        this.latch = latch;
    }

    /**
     * 连接客户端成功
     */
    @Override
    public void completed(AsynchronousSocketChannel socketChannel, AIOSocketServer socketServer) {
        AIOSocketServer.clientCount ++;
        System.out.println(BaseConstant.CLIENT_COUNT_PLUS_MSG + AIOSocketServer.clientCount);
        // 接收客户端的请求
        serverSocketChannel.accept(socketServer, this);
        // 创建新的 buffer，
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        // 异步接收客户端消息，第三个参数为接受消息的回调业务Handler
        socketChannel.read(buffer , buffer, new ReadHandler(socketChannel));
    }

    /**
     * 连接客户端失败
     */
    @Override
    public void failed(Throwable exc, AIOSocketServer attachment) {
        exc.printStackTrace();
        latch.countDown();
    }

}
