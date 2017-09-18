package com.rxx.websocket;

import javax.websocket.Session;

/**
 * Created by zd on 2017/8/21.
 */
public interface IWebSocket {
    void onOpen(Session currentSession);
    void onMessage(String message, Session currentSession);
    void onClose(Session currentSession);
    void onError(Session currentSession, Throwable error);
}
