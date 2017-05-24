package com.rxx.designpattern.factorymethod;
/**
 * @Title      :FactoryMethodTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 上午11:26:26
 */
public class TestFactoryMethod {
	public static void main(String[] args) {
		new MailSenderFactory().produce().Send();
		new SmsSenderFactory().produce().Send();
	}
}
