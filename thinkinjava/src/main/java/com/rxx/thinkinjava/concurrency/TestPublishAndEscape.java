package com.rxx.thinkinjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :Test
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月5日 下午5:03:09
 */
public class TestPublishAndEscape {
	
	private final static List<Integer> list = new ArrayList<>();

	public TestPublishAndEscape() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "TestPublishAndEscape...";
	}
	
	public static void main(String[] args) {
		final TestPublishAndEscape test = new TestPublishAndEscape();
		ExecutorService exec = Executors.newCachedThreadPool();
		list.add(1);
		exec.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(test);
			}
		});
	}
	
}
