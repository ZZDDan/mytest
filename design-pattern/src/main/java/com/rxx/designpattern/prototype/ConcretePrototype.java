package com.rxx.designpattern.prototype;
/**
 * @Title      :ConcretePrototype
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午3:10:47
 */
public class ConcretePrototype extends Prototype {
	
	private static final long serialVersionUID = 1L;

	public ConcretePrototype(String name, SerializableObject obj) {
		setName(name);
		setObj(obj);
	}
}
