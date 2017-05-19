package com.rxx.thinkinjava.concurrency;

/**
 * @Title :LiftOff
 * @Description:
 * @Company :
 * @author :zhangdan
 * @date :2017年3月13日 上午11:14:06
 */
public class LiftOff implements Runnable {
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}
}
