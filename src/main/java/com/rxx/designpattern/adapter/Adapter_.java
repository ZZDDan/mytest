package com.rxx.designpattern.adapter;
/**
 * @Title      :Adapter
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午3:42:36
 */
public class Adapter_ implements Target {

	private Adaptee adaptee;
	
	public Adapter_(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public void adapteeMethod() {
		adaptee.adapteeMethod();
	}

	@Override
	public void adapterMethod() {
		System.out.println("Adapter method!");
	}

}
