package com.rxx.designpattern.mediator;
/**
 * @Title      :User
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午2:49:48
 */
public abstract class User {
	private Mediator mediator;  
    
    public Mediator getMediator(){  
        return mediator;  
    }  
      
    public User(Mediator mediator) {  
        this.mediator = mediator;  
    }  
  
    public abstract void work();  
}
