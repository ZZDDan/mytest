package com.rxx.socket.bio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * @Title      :TestBIO
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月6日 下午5:07:35
 */
public class TestBIO {

	@Test
	public void testServer(){
		ChartServer server = new ChartServer(9000);
		server.start();
	}
	
	@Test
	public void testClient(){
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.execute(new Client());
		}
	}
	
}
