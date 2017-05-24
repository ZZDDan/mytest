package com.rxx.designpattern.stratege;
/**
 * @Title      :Multiply
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午6:50:52
 */
public class Multiply extends AbstractCalculator implements ICalculator {  
    @Override  
    public int calculate(String exp) {  
        int arrayInt[] = split(exp,"\\*");  
        return arrayInt[0]*arrayInt[1];  
    }  
}  
