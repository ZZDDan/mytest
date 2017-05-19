package com.rxx.designpattern.observer;
/**
 * @Title      :Observer1
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午9:54:43
 */
public class Observer1 implements Observer {  
    @Override  
    public void update() {  
        System.out.println("observer1 has received!");  
    }  
}
