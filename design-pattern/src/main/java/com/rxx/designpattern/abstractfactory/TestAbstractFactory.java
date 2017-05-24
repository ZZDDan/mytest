package com.rxx.designpattern.abstractfactory;
/**
 * @Title      :TestAbstractFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 下午2:41:02
 */
public class TestAbstractFactory {
	public static void main(String[] args) {
		new BlackAnimalFactory().createCat().eat();
		new BlackAnimalFactory().createDog().eat();
		new WhiteAnimalFactory().createCat().eat();
		new WhiteAnimalFactory().createDog().eat();
	}
}
