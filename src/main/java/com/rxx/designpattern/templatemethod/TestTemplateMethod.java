package com.rxx.designpattern.templatemethod;


/**
 * @Title      :TestStratege
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午6:53:52
 */
public class TestTemplateMethod {
	public static void main(String[] args) {  
		String exp = "8+8";  
        AbstractCalculator cal = new Plus();  
        int result = cal.calculate(exp, "\\+");  
        System.out.println(result);  
    }  
}
