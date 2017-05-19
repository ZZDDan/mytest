package com.rxx.designpattern.builder;
/**
 * @Title      :TestBuilder
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 上午11:19:18
 */
public class TestBuilder {

	public static void main(String[] args) {
		Person person = new PersonDirector().constructorPerson(new ManBuilder());
		System.out.println(person.getHead());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());
	}
}
