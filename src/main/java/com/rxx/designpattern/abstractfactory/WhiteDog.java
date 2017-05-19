package com.rxx.designpattern.abstractfactory;
/**
 * @Title      :WhiteDog
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 下午2:37:37
 */
public class WhiteDog implements IDog {
	@Override
	public void eat() {
		System.out.println("The white dog is eating!");
	}
}
