package com.rxx.designpattern.observer;
/**
 * @Title      :Subject
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午9:55:16
 */
public interface Subject {
	/*增加观察者*/  
    public void add(Observer observer);  
      
    /*删除观察者*/  
    public void del(Observer observer);  
      
    /*通知所有的观察者*/  
    public void notifyObservers();  
      
    /*自身的操作*/  
    public void operation(); 
}
