package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :Sleeper
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 上午9:36:11
 */
class Sleeper extends Thread {
	
	private int duration;
	public Sleeper(int duration, String name) {
		super(name);
		this.duration = duration;
		start();
	}
	
	@Override
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + " is interrupted.isInterrupted " + isInterrupted());
			return ;
		}
		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread{
	
	private Sleeper sleeper;

	public Joiner(Sleeper sleeper, String name) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}
		System.out.println(getName() + " join completed");
	}
}