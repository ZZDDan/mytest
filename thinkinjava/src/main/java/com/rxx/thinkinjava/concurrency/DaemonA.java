package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :DaemonA
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午5:16:20
 */
public class DaemonA implements Runnable{

	@Override
	public void run() {
		System.out.println("DaenonA started");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupt");
		}finally{
			System.out.println("This should always run?");
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonA());
		//thread.setDaemon(true);
		thread.start();
	}
}
