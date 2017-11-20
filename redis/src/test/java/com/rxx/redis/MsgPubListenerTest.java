package com.rxx.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zd on 2017/8/21.
 * 消息发布者
 */
public class MsgPubListenerTest {
    public static void main(String[] args) {
        Jedis jedis = RedisUtil.getJedis();
        try {
            List<String> data = new ArrayList<>();
            for (int i = 0; i < 1; i++) {
                data.add("{" +
                        "EVENT_ID: \"445454512484321254213\"," +
                        "LOG_BIG_TYPE: \"DNS-HIJACKING\"," +
                        "EVENT_TYPE: \"DNSlog\"," +
                        "TIME: \"" + new Date().getTime() + "\"," +
                        "DNS_SERVER: \"117.131.221.150\"," +
                        "DOMAIN_NAME: \"wxyjs.org.cn\"," +
                        "HIJACKING_IP: \"117.131.221.150\"," +
                        "NORMAL_IP: \"117.131.221.150\"" +
                        "}");
            }
            for (String ack : data) {
                jedis.rpush("attack-queue", ack);
                jedis.publish("attack", ack);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }

    }
}
