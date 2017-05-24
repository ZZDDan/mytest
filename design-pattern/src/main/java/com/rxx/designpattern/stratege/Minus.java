package com.rxx.designpattern.stratege;
/**
 * @Title      :Minus
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午6:50:36
 */
public class Minus extends AbstractCalculator implements ICalculator {  
    @Override  
    public int calculate(String exp) {  
        int arrayInt[] = split(exp,"-");  
        return arrayInt[0]-arrayInt[1];  
    }  
}  