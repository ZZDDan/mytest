package com.rxx.designpattern.templatemethod;
/**
 * @Title      :Plus
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午7:23:59
 */
public class Plus extends AbstractCalculator {  
    @Override  
    public int calculate(int num1,int num2) {  
        return num1 + num2;  
    }  
}
