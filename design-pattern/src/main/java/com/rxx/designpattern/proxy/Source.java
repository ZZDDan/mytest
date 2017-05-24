package com.rxx.designpattern.proxy;
/**
 * @Title      :Source
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午4:57:05
 */
public class Source implements Sourceable {
	@Override
	public void method() {
		System.out.println("the original method!");  
	}  
}  