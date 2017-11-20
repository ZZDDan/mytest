package com.rxx.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by zd on 2017/8/21.
 * @author zhangdan
 * 监听 消息的订阅
 */
public class MsgPubSubListener extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        super.onMessage(channel, message);
        System.out.println("channel:" + channel + "receives message :" + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        super.onSubscribe(channel, subscribedChannels);
    }
}
