package com.rxx.socketdemo.socket.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.concurrent.ThreadPoolTaskExecutor;
import com.rxx.socketdemo.socket.IOSocketServer;

/**
 * @Title      :NIOSocketServer
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月17日 上午9:34:30
 */
public class NIOSocketServer implements IOSocketServer {

    public volatile static int clientCount; 
    
    @Override
    public void start(String addr, int port) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();
        // 打开监听通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // true:此通道被设置被阻塞模式，false：此通道被设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(addr, port), 1024);
        // 监听客户端连接请求
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 标记服务器已开启
        System.out.println(BaseConstant.SERVER_STARTED_MSG + port);
        
        ThreadPoolTaskExecutor.getInstance().execute(new NIOSocketServerHandler(selector));
    }

}
