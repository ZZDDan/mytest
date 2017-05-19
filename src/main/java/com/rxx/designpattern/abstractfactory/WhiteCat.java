package com.rxx.designpattern.abstractfactory;
/**
 * @Title      :WhiteCat
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 下午2:37:46
 */
public class WhiteCat implements ICat {
	@Override
	public void eat() {
		System.out.println("The white cat is eating!");
	}
}
