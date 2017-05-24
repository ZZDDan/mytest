package com.rxx.designpattern.builder;
/**
 * @Title      :ManBuilder
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 上午11:12:12
 */
public class ManBuilder implements PersonBuilder {
	
	Person person;
	
	public ManBuilder() {
		person = new Man();
	}
	
	@Override
	public void buildHead() {
		person.setHead("建造男人的头");
	}

	@Override
	public void buildBody() {
		person.setBody("建造男人的身体");
	}

	@Override
	public void buildFoot() {
		person.setFoot("建造男人的脚");
	}

	@Override
	public Person buildPerson() {
		return person;
	}

}
