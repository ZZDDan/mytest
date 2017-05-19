package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :SimpleThread
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午5:34:49
 */
public class SimpleThread extends Thread{

	private int countDown = 5;
	private static int threadCount = 0;
	
	public SimpleThread() {
		super(++ threadCount + "");
		start();
	}

	@Override
	public void run() {
		while(true){
			System.out.print(this + "\t");
			if(--countDown  == 0){
				return ;
			}
		}
	}
	
	@Override
	public String toString() {
		return "#" + getName() + "(" + countDown + ")";
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new SimpleThread();
		}
	}
}
