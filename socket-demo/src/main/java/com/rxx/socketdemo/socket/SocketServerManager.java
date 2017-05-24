package com.rxx.socketdemo.socket;

import java.io.IOException;

/**
 * @Title      :SocketExecutor
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月10日 下午3:48:09
 */
public class SocketServerManager {
    
    public void start(SocketConfig socketConfig){

        try {
            IOSocketServer server = socketConfig.getServerClass().newInstance();
            server.start(socketConfig.getIp(), socketConfig.getPort());
        } catch (InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    
    }
    
    public static void main(String[] args) {
        SocketConfig socketConfig = SocketConfig.getInstance();
        new SocketServerManager().start(socketConfig);
    }
    
}
