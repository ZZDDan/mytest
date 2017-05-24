package com.rxx.designpattern.mediator;
/**
 * @Title      :TestMediator
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午2:51:05
 */
public class TestMediator {
	public static void main(String[] args) {  
        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();  
    }  
}
