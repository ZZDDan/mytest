package com.rxx.thinkinjava.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class AtomicityTest implements Runnable {
	private int i = 0;
	public synchronized int getValue() {
		return i;
	}
	private synchronized void evenIncrement() {
		i++;
		i++;
	}
	public void run() {
		while (true)
			evenIncrement();
	}
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			public void run() {
				System.err.println("Aborting");
				System.exit(0);
			}
		}, 5000); // Terminate after 5 seconds
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while (true) {
			int val = at.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}