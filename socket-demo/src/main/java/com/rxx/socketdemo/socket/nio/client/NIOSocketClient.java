package com.rxx.socketdemo.socket.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import com.rxx.socketdemo.concurrent.ThreadPoolTaskExecutor;
import com.rxx.socketdemo.socket.IOSocketClient;

/**
 * @Title      :NIOSocketClient
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月17日 上午9:35:41
 */
public class NIOSocketClient implements IOSocketClient {
    
    private NIOSocketClientHandler nioSocketClientHandler;
    
    @Override
    public void start(String addr, int port) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();
        // 打开监听通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞模式
        socketChannel.configureBlocking(false);
        nioSocketClientHandler = new NIOSocketClientHandler(selector, socketChannel, new InetSocketAddress(addr, port));
        ThreadPoolTaskExecutor.getInstance().execute(nioSocketClientHandler);
    }

    @Override
    public boolean sendMsg(String msg) {
        try {
            nioSocketClientHandler.sendMsg(msg);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void close() {
        nioSocketClientHandler.close();
    }

}
