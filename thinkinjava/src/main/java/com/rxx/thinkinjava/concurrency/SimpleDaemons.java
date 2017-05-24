package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :SimpleDaemons
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午3:06:36
 */
public class SimpleDaemons implements Runnable{

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			} catch (InterruptedException e) {
				System.out.println("sleep() interrupt  ");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new SimpleDaemons());
			thread.setDaemon(true);// 必须在 start() 之前
			thread.start();
		}
		System.out.println("All daemons started!");
		Thread.sleep(120);
	}
}
