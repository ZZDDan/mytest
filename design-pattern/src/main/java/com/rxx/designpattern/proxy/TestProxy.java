package com.rxx.designpattern.proxy;
/**
 * @Title      :TestProxy
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午5:04:29
 */
public class TestProxy {
	public static void main(String[] args) {  
        Sourceable source = new Proxy(); 
        source.method();  
    }
}
