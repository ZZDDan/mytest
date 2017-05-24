package com.rxx.designpattern.builder;
/**
 * @Title      :PersonBuilder
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 上午11:11:00
 */
public interface PersonBuilder {
	void buildHead();
	void buildBody();
	void buildFoot();
	Person buildPerson();
}
