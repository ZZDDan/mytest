package com.rxx.designpattern.state;
/**
 * @Title      :State
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午1:58:42
 */
public class State {
	private String value;  
    
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
  
    public void method1(){  
        System.out.println("execute the first opt!");  
    }  
      
    public void method2(){  
        System.out.println("execute the second opt!");  
    }  
}
