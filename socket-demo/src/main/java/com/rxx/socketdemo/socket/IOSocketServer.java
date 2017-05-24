package com.rxx.socketdemo.socket;

import java.io.IOException;

/**
 * @Title      :IOServer
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月10日 下午1:54:39
 */
public interface IOSocketServer {
    void start(String addr, int port) throws IOException;
}
