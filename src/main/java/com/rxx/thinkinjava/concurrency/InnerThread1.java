
package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :InnerThread1
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月17日 上午9:28:55
 */
public class InnerThread1 {

	private int countDown = 5;
	private Inner inner;
	
	private class Inner extends Thread {
		
		public Inner(String name) {
			super(name);
			start();
		}
		
		@Override
		public void run() {
			while(true){
				System.out.println(this);
				if(--countDown == 0){
					return ;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("sleep() interrupt");
				}
			}
		}
		
		@Override
		public String toString() {
			return getName() + ":" + countDown;
		}
	}
	
	public InnerThread1(String name){
		inner = new Inner(name);
	}
}
