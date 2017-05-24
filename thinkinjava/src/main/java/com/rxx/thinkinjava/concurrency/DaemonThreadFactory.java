package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @Title      :DaemonThreadFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午3:38:58
 */
public class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setDaemon(true);
		return thread;
	}
}
