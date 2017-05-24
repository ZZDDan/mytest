package com.rxx.socketdemo.socket.aio.client;

import java.io.IOException;
import java.nio.channels.CompletionHandler;

/**
 * @Title      :AsyncClientHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月15日 上午10:06:29
 */
public class AsyncClientHandler implements CompletionHandler<Void, AIOSocketClient> {

    /**
     * 连接服务器成功，意味着TCP三次握手完成
     */
    @Override
    public void completed(Void result, AIOSocketClient attachment) {
        //System.out.println("客户端成功连接到服务器");
    }

    @Override
    public void failed(Throwable exc, AIOSocketClient socketClient) {
        //System.out.println("连接服务器失败");
        try {
            socketClient.socketChannel.close();
            socketClient.latch.countDown();
            socketClient = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
