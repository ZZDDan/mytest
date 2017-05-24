package com.rxx.designpattern.abstractfactory;
/**
 * @Title      :BlackDog
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 下午2:38:00
 */
public class BlackDog implements IDog {
	@Override
	public void eat() {
		System.out.println("The black dog is eating!");
	}
}
