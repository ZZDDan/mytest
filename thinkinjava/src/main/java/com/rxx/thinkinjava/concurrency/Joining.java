package com.rxx.thinkinjava.concurrency;
/**
 * @Title      :Joining
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 上午10:52:40
 */
public class Joining {
	public static void main(String[] args) {
		Sleeper sleeper = new Sleeper(1500, "sleeper");
		Sleeper grumpy = new Sleeper(1500, "grumpy");
		@SuppressWarnings("unused")
        Joiner dopey = new Joiner(sleeper, "dopey");
		@SuppressWarnings("unused")
        Joiner doc = new Joiner(grumpy, "doc");
		//grumpy.interrupt();
	}
}
