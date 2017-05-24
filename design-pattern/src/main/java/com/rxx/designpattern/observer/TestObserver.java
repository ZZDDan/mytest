package com.rxx.designpattern.observer;
/**
 * @Title      :TestObserver
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午9:56:51
 */
public class TestObserver {
	public static void main(String[] args) {  
        Subject sub = new MySubject();  
        sub.add(new Observer1());  
        sub.add(new Observer2());  
          
        sub.operation();  
    }  
}
