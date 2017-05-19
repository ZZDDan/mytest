package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :TestDaemon
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午4:56:19
 */
public class TestDaemon {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Daemon());
		thread.setDaemon(true);
		thread.start();
		System.out.println("thread isDaemon() = " + thread.isDaemon() + "\t");
		Thread.sleep(500);
	}
}
