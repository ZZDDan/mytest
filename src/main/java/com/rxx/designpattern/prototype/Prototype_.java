package com.rxx.designpattern.prototype;
/**
 * @Title      :Prototype
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午3:08:23
 */
public class Prototype_ implements Cloneable {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
