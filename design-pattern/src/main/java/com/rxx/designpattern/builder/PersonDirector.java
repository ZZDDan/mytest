package com.rxx.designpattern.builder;
/**
 * @Title      :PersonDirector
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 上午11:16:07
 */
public class PersonDirector {

	public Person constructorPerson(PersonBuilder pb){
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();
	}
}
