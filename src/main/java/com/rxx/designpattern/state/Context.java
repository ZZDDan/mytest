package com.rxx.designpattern.state;
/**
 * @Title      :Context
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午1:59:20
 */
public class Context {
	private State state;  
	  
    public Context(State state) {  
        this.state = state;  
    }  
  
    public State getState() {  
        return state;  
    }  
  
    public void setState(State state) {  
        this.state = state;  
    }  
  
    public void method() {  
        if (state.getValue().equals("state1")) {  
            state.method1();  
        } else if (state.getValue().equals("state2")) {  
            state.method2();  
        }  
    }  
}
