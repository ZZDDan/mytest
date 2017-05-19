package com.rxx.designpattern.factorymethod;
/**
 * @Title      :SendMailFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 上午11:21:51
 */
public class SmsSenderFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
