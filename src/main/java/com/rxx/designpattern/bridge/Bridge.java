package com.rxx.designpattern.bridge;
/**
 * @Title      :Bridge
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午5:19:47
 */
public abstract class Bridge {
	private Sourceable source;  
	  
    public void method(){  
        source.method();  
    }  
      
    public Sourceable getSource() {  
        return source;  
    }  
  
    public void setSource(Sourceable source) {  
        this.source = source;  
    }  
}
