package com.rxx.designpattern.chain;
/**
 * @Title      :TestChain
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午10:56:33
 */
public class TestChain {
	public static void main(String[] args) {  
        MyHandler h1 = new MyHandler("h1");  
        MyHandler h2 = new MyHandler("h2");  
        MyHandler h3 = new MyHandler("h3");  
  
        h1.setHandler(h2);  
        h2.setHandler(h3);  
  
        h1.operator();  
    }  
}
