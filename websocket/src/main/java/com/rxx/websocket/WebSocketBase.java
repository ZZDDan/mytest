package com.rxx.websocket;

import org.apache.log4j.Logger;

import javax.websocket.*;
import java.io.IOException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zd on 2017/8/21.
 */
public abstract class WebSocketBase {

    private static final Logger logger = Logger.getLogger(WebSocketBase.class);

    /**
     * 存储当前有效的session对象
     */
    protected static Queue<Session> sessionSet = new ConcurrentLinkedQueue<Session>();
    public static Queue<Session> getSessionSet() {
        return sessionSet;
    }

    /**
     * 打开连接时调用的方法
     * @param currentSession
     */
    public void onOpen(Session currentSession) {
        logger.debug("Server say：Client connected");

        if (sessionSet.contains(currentSession) == false) {
            sessionSet.add(currentSession);
            logger.debug("WebSocketTest.onOpen()================Add=" + sessionSet.size());
        }

    }

    /**
     * 接收消息时调用的方法
     * @param message
     * @param currentSession
     */
    public void onMessage(String message, Session currentSession) {
        logger.debug("Server say：Received: " + message);

        try {
            // 获得有多少条连接
            final Set<Session> sessions = currentSession.getOpenSessions();
            logger.debug("检测到连接服务器是对象数量是" + sessions.size());

            // 客户端关闭
            if ("close".equals(message)) {
                currentSession.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接时调用的方法
     * @param currentSession
     */
    public void onClose(Session currentSession) {
        logger.debug("Server say：Connection closed============Close=" + sessionSet.size());

        if (sessionSet.contains(currentSession)) {
            sessionSet.remove(currentSession);
        }

    }

    /**
     * 发生错误时调用
     * @param currentSession
     * @param error
     */
    public void onError(Session currentSession, Throwable error){
        logger.debug("Server say：Client error");

        if (sessionSet.contains(currentSession)) {
            sessionSet.remove(currentSession);
        }
        error.printStackTrace();
    }

}
