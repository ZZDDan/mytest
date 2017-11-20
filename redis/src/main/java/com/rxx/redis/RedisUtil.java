package com.rxx.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public final class RedisUtil {


	/**
	 * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	 */
  	private static int MAX_IDLE = 50;

	/**
	 * 控制一个pool最多连接数
	 */
	private static int MAX_TOTAL = 200;

	/**
	 * 超时时间
	 */
	private static int TIMEOUT = 10000;
  	
  	private static JedisPool jedisPool = null;
  	static{
  		//#Redis服务器IP
  		String  redisAddr= "192.168.170.102";
  		//redis auth 认证
  		String redisAuth="ultrapower2015";
  		//redis 端口
  		int redisPort= 6379;
  		GenericObjectPoolConfig config=new GenericObjectPoolConfig();
  		config.setMaxIdle(MAX_IDLE);
  		config.setMaxTotal(MAX_TOTAL);
  	     System.out.println("redis服务器配置【ip】="+redisAddr+" 【port】="+redisPort+" 【auth】="+redisAuth);
  		jedisPool = new JedisPool(config, redisAddr, redisPort, TIMEOUT, redisAuth);
  	}
  	
  	public static Jedis getJedis() {
          Jedis jedis = jedisPool.getResource();
         return jedis;
  	}

  	public static void destory() {
  	    if (jedisPool != null) {
  	        jedisPool.destroy();
  	    }
  	}
}