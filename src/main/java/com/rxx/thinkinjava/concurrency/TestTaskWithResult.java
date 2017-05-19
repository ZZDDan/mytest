package com.rxx.thinkinjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Title      :TestTaskWithResult
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 上午11:26:31
 */
public class TestTaskWithResult {

	public static void main(String[] args) {
		
		List<Future<String>> futures = new ArrayList<>();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			futures.add(exec.submit(new TaskWithResult(i)));
		}
		
		for (Future<String> future : futures) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
		}
	}
}
