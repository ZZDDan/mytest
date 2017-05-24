package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :DaemonFromFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午3:45:29
 */
public class DaemonFromFactory implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(" sleep() interrupt ");
			}
			System.out.println(Thread.currentThread() + " " + this);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 5; i++) {
			exec.execute(new DaemonFromFactory());
		}
		System.out.println("All daemons started！");
		Thread.sleep(200);
	}

}
