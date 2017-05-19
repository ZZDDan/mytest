package com.rxx.designpattern.chain;
/**
 * @Title      :AbstractHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午10:55:11
 */
public abstract class AbstractHandler {
	private Handler handler;  
	  
    public Handler getHandler() {  
        return handler;  
    }  
  
    public void setHandler(Handler handler) {  
        this.handler = handler;  
    }  
}
