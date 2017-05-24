package com.rxx.thinkinjava.concurrency;

/**
 * @Title      :ThreadMethod
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月18日 下午5:00:28
 */
public class ThreadMethod {

	
	private Thread t;
	private String name;
	private int countDown = 5;
	
	public ThreadMethod(String name) {
		this.name = name;
	}

	public void runTask(){
		if(t == null ){
			t = new Thread(name){
				@Override
				public void run() {
					while (true) {
						System.out.println(this);
						if(-- countDown == 0){
							return; 
						}
						try {
							sleep(100);
						} catch (InterruptedException e) {
							System.out.println("sleep() interrupted");
						}
					}
				}
				@Override
				public String toString() {
					return getName() + ":" + name;
				}
			};
		}
		
		t.start();
	}
}
