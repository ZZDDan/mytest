package com.rxx.socketdemo.socket.aio.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.msg.MsgHandler;

/**
 * @Title      :ReadHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月12日 下午2:43:20
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    // 用于读取半包消息和发送应答
    private AsynchronousSocketChannel socketChannel;
    public ReadHandler(AsynchronousSocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    /**
     * 读取到消息后的操作
     */
    @Override
    public void completed(Integer operation, ByteBuffer buffer) {
        //flip操作 ：翻转缓冲区
        buffer.flip();
        byte[] message = new byte[buffer.remaining()];
        buffer.get(message);
        
        try {
            String msg = new String(message, BaseConstant.CHARSET);
            if(BaseConstant.QUIT.equals(msg)){
                AIOSocketServer.clientCount --;
                System.out.println(BaseConstant.CLIENT_COUNT_MINUS_MSG + AIOSocketServer.clientCount);
                return;
            }
            byte[] result = MsgHandler.acceptMsg(msg);
            // 操作结果发送给客户端
            doWrite(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
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

    /**
     * 给客户端发送消息
     * @param calResult
     */
    private void doWrite(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        // 异步发送消息给客户端，第三个参数发送消息的回调函数
        socketChannel.write(buffer, buffer, new WriteHandler(socketChannel));
    }

}
