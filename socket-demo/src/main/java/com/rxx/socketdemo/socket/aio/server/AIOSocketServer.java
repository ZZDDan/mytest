package com.rxx.socketdemo.socket.aio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.concurrent.ThreadPoolTaskExecutor;
import com.rxx.socketdemo.socket.IOSocketServer;

/**
 * @Title      :AioSocketServer
 * @Description:创建服务器通道
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月12日 下午2:18:12
 */
public class AIOSocketServer implements IOSocketServer {

    public volatile static int clientCount;// 客户端的连接个数
    private AsynchronousServerSocketChannel serverSocketChannel;
    private CountDownLatch latch;
    
    @Override
    public void start(String addr, int port) throws IOException {
        
        // 创建服务端通道、绑定端口
        serverSocketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(addr, port));
        System.out.println(BaseConstant.SERVER_STARTED_MSG + port);
        
        final AIOSocketServer socketServer = this; 
        ThreadPoolTaskExecutor.getInstance().execute(new Runnable() {
            
            @Override
            public void run() {
                //CountDownLatch初始化  
                //它的作用：在完成一组正在执行的操作之前，允许当前的现场一直阻塞  
                //此处，让现场在此阻塞，防止服务端执行完成后退出  
                //也可以使用while(true)+sleep   
                //生成环境就不需要担心这个问题，以为服务端是不会退出的  
                latch = new CountDownLatch(1);
                // 用于接收客户端连接
                serverSocketChannel.accept(socketServer, new AcceptHandler(serverSocketChannel, latch));
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        });
    }

}
