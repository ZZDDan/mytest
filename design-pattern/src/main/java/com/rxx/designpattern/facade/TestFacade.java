package com.rxx.designpattern.facade;
/**
 * @Title      :TestFacade
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午6:04:25
 */
public class TestFacade {

	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}
}
