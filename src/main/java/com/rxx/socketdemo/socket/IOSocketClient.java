package com.rxx.socketdemo.socket;

import java.io.IOException;

/**
 * @Title      :IOSocket
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月10日 下午1:55:06
 */
public interface IOSocketClient {
    
    void start(String addr, int port) throws IOException;

    boolean sendMsg(String msg);

    void close();
}
