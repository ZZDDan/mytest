package com.rxx.designpattern.observer;
/**
 * @Title      :MySubject
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午9:56:11
 */
public class MySubject extends AbstractSubject {  
    @Override  
    public void operation() {  
        System.out.println("update self!");  
        notifyObservers();  
    }  
}
