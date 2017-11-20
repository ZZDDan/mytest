package com.rxx.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by zd on 2017/8/21.
 * 消息消费者
 */
public class MsgSubListenerTest {
    public static void main(String[] args) {
        Jedis jedis = RedisUtil.getJedis();
        try {
            MsgPubSubListener listener = new MsgPubSubListener();
            jedis.subscribe(listener,"attack");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (null != jedis){
                jedis.close();
            }
        }

    }
}
