package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :SimplePrioritys
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午2:30:09
 */
public class SimplePrioritys implements Runnable {

	private int countDown = 5;
	@SuppressWarnings("unused")
    private volatile double d;
	private int priority;
	
	public SimplePrioritys(int priority) {
		this.priority = priority;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			// 执行一个耗时的操作
			for (int i = 0; i < 100000; i++) {
				d += (Math.PI + Math.E)/(double)i;
				if( i % 1000 == 0)
					Thread.yield();
			}
			System.out.print(this);
			if(--countDown == 0){
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		return Thread.currentThread() + ":" + countDown;
	}

}
