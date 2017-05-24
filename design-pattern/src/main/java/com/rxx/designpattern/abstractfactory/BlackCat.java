package com.rxx.designpattern.abstractfactory;
/**
 * @Title      :BlackCat
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 下午2:37:54
 */
public class BlackCat implements ICat {
	@Override
	public void eat() {
		System.out.println("The black cat is eating!");
	}
}
