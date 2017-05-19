package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :SettingDefaultHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 下午3:51:55
 */
public class SettingDefaultHandler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread());
	}
}
