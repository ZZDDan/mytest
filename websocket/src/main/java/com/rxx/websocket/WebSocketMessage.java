package com.rxx.websocket;

import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@ServerEndpoint(value = "/websocket", encoders = { ServerEncoder.class })
public class WebSocketMessage extends WebSocketBase {

    private static Logger log = Logger.getLogger(WebSocketMessage.class);

    @Override
    @OnOpen
    public void onOpen(Session currentSession) {
        super.onOpen(currentSession);
        // 当有一个新的连接连入时，向所有连接发送消息，然后再用定时器定时发送消息
        Queue<Session> sessions = WebSocketMessage.getSessionSet();

        // 需要发送的数据
        List<String> list = new ArrayList<>();
        list.add("test");

        // 为所有的客户端发送数据
        for (final Session session: sessions) {
            synchronized (session) {
                if(session != null && session.isOpen()){
                    try {
                        RemoteEndpoint.Basic remote = session.getBasicRemote();
                        remote.sendObject(list);
                    } catch (IOException | EncodeException e) {
                        log.error("向客户端发送消息失败", e);
                    }
                }
            }
        }
    }

    @Override
    @OnMessage
    public void onMessage(String message, Session currentSession) {
        super.onMessage(message,currentSession);
    }


    @Override
    @OnClose
    public void onClose(Session currentSession) {
        super.onClose(currentSession);
    }

    /**
     * 发生错误时调用
     */
    @Override
    @OnError
    public void onError(Session currentSession, Throwable error){
        super.onError(currentSession, error);
    }

}