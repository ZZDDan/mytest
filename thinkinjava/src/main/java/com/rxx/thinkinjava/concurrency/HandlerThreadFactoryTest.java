package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :HandlerThreadFactoryTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 下午3:36:55
 */
public class HandlerThreadFactoryTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}
