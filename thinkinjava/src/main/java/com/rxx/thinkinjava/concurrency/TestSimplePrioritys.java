package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :TestSimplePrioritys
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午2:41:22
 */
public class TestSimplePrioritys {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SimplePrioritys(Thread.MIN_PRIORITY));
		}
		exec.execute(new SimplePrioritys(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
