package com.rxx.socketdemo.socket.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.concurrent.ThreadPoolTaskExecutor;
import com.rxx.socketdemo.socket.IOSocketServer;

/**
 * @Title      :BIOSocketServer
 * @Description:阻塞式I/O创建的服务端
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月10日 下午2:13:49
 */
public class BIOSocketServer implements IOSocketServer {
    public volatile static int clientCount;
    ServerSocket serverSocket; 
    
    /**
     * 这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
     */
    @Override
    public void start(String addr, int port) throws IOException {
        if(serverSocket != null) return;  
        try {
            // 通过构造函数创建ServerSocket  
            // 如果端口合法且空闲，服务端就监听成功
            serverSocket = new ServerSocket(port);
            System.out.println(BaseConstant.SERVER_STARTED_MSG + port);
            Socket socket = null;
            // 通过无线循环监听客户端连接  
            // 如果没有客户端接入，将阻塞在accept操作上。  
            while(true){
                socket = serverSocket.accept();
                // 连接成功
                BIOSocketServer.clientCount ++;
                System.out.println(BaseConstant.CLIENT_COUNT_PLUS_MSG + BIOSocketServer.clientCount);
                // 当有新的客户端接入时，会执行下面的代码  
                // 然后创建一个新的线程处理这条Socket链路
                ThreadPoolTaskExecutor.getInstance().execute(new ServerHandler(socket));
            }
            
        } finally {
            // 一些必要的清理工作  
            if(serverSocket != null){
                serverSocket.close();
                System.out.println(BaseConstant.SERVER_STOPED_MSG);
                serverSocket = null;
            }
        }
    }
    
}
