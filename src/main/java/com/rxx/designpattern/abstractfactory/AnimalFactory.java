package com.rxx.designpattern.abstractfactory;
/**
 * @Title      :AnimalFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 下午2:33:42
 */
public interface AnimalFactory {
	ICat createCat();
	IDog createDog();
}
