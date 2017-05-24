package com.rxx.designpattern.decorator;
/**
 * @Title      :TestDerocator
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午5:52:05
 */
public class TestDerocator {
	public static void main(String[] args) {
		Sourceable source = new Source();
		Decorator decorator = new Decorator(source);
		decorator.method();
	}
}
