package com.rxx.designpattern.interpret;
/**
 * @Title      :Context
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午3:05:17
 */
public class Context {
	private int num1;  
    private int num2;  
      
    public Context(int num1, int num2) {  
        this.num1 = num1;  
        this.num2 = num2;  
    }  
      
    public int getNum1() {  
        return num1;  
    }  
    public void setNum1(int num1) {  
        this.num1 = num1;  
    }  
    public int getNum2() {  
        return num2;  
    }  
    public void setNum2(int num2) {  
        this.num2 = num2;  
    }  
}
