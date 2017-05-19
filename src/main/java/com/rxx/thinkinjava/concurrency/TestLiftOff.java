package com.rxx.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :TestLiftOff
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月13日 上午11:27:20
 */
public class TestLiftOff {

	public static void main(String[] args) {
		/*for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}*/
		
		//System.out.println("====================== CachedThreadPool ========================");
		/*ExecutorService execCache = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			execCache.execute(new LiftOff());
		}
		execCache.shutdown();*/
		
		//System.out.println("====================== FixedThreadPool ========================");
		/*ExecutorService execFixed = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 7; i++) {
			execFixed.execute(new LiftOff());
		}
		execFixed.shutdown();*/
		
		System.out.println("====================== SingleThreadExecutor ========================");
		ExecutorService execSingle = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			execSingle.execute(new LiftOff());
		}
		execSingle.shutdown();
	}
}
