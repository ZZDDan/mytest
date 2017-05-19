package com.rxx.designpattern.prototype;

import java.io.IOException;

/**
 * @Title      :TestClone
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午3:12:52
 */
public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		ConcretePrototype pro1 = new ConcretePrototype(new String("prototype"), new SerializableObject());
		ConcretePrototype pro2 = (ConcretePrototype) pro1.clone();
		System.out.println(pro1.getName());		
		System.out.println(pro1.getObj());		
		System.out.println(pro2.getName());		
		System.out.println(pro2.getObj());		
		ConcretePrototype pro3 = new ConcretePrototype(new String("deep prototype"), new SerializableObject());
		ConcretePrototype pro4 = (ConcretePrototype) pro3.deepClone();
		System.out.println(pro3.getName());		
		System.out.println(pro3.getObj());		
		System.out.println(pro4.getName());		
		System.out.println(pro4.getObj());		
	}
}
