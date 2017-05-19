package com.rxx.designpattern.state;
/**
 * @Title      :TestState
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午2:00:59
 */
public class TestState {
	public static void main(String[] args) {  
        State state = new State();  
        Context context = new Context(state);  
        //设置第一种状态  
        state.setValue("state1");  
        context.method();  
        //设置第二种状态  
        state.setValue("state2");  
        context.method();  
    }  
}
