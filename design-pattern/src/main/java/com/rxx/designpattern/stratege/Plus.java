package com.rxx.designpattern.stratege;
/**
 * @Title      :Plus
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午6:50:13
 */
public class Plus extends AbstractCalculator implements ICalculator {  
    @Override  
    public int calculate(String exp) {  
        int arrayInt[] = split(exp,"\\+");  
        return arrayInt[0]+arrayInt[1];  
    }  
}  