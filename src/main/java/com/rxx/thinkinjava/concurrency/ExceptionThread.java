package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.Executors;

/**
 * @Title      :ExceptionThread
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 下午2:33:25
 */
public class ExceptionThread implements Runnable{

	@Override
	public void run() {
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		Executors.newCachedThreadPool().execute(new ExceptionThread());
		/*try {
			Executors.newCachedThreadPool().execute(new ExceptionThread());
		} catch (Exception e) {
			System.out.println("Exception has bean handled!");
		}*/
	}
}
