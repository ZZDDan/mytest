package com.rxx.designpattern.singleton;
/**
 * @Title      :Singleton
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午2:57:13
 */
public class Singleton {
	private static Singleton instance = null;  
	private Singleton() {}  
	private static synchronized void syncInit() {  
	    if (instance == null) {  
	        instance = new Singleton();  
	    }  
	}  
	public static Singleton getInstance() {  
	    if (instance == null) {  
	        syncInit();  
	    }  
	    return instance;  
	}  
}
