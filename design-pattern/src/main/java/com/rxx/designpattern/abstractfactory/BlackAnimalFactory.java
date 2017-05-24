package com.rxx.designpattern.abstractfactory;
/**
 * @Title      :BlackAnimalFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 下午2:35:13
 */
public class BlackAnimalFactory implements AnimalFactory {
	@Override
	public ICat createCat() {
		return new BlackCat();
	}
	@Override
	public IDog createDog() {
		return new BlackDog();
	}
}
