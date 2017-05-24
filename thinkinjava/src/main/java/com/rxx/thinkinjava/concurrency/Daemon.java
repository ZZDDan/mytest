package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :Daemon
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午4:56:59
 */
public class Daemon implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new DaemonSpawn());
			thread.start();
			System.out.println("DaemonSpawn " + i + " started, isDaemon() = " + thread.isDaemon());
		}
		
		while(true){
			Thread.yield();
		}
	}

}
