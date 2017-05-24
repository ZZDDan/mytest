package com.rxx.designpattern.singleton;
/**
 * @Title      :TestSingleton
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午2:57:24
 */
public class TestSingleton {
	public static void main(String[] args) {
		Singleton sing = Singleton.getInstance();
		Singleton sing2 = Singleton.getInstance();
		System.out.println(sing);
		System.out.println(sing2);
	}
}
