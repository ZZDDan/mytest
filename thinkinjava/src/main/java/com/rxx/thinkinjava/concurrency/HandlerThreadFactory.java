package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @Title      :HandlerThreadFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 下午2:56:15
 */
public class HandlerThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");
		Thread thread = new Thread(r);
		System.out.println("Created " + thread + "ID:" + thread.getId());
		thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh = " + thread.getUncaughtExceptionHandler());
		return thread;
	}
}
