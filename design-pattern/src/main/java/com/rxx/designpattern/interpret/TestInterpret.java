package com.rxx.designpattern.interpret;
/**
 * @Title      :TestInterpret
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午3:06:22
 */
public class TestInterpret {
	public static void main(String[] args) {  
        // 计算9+2-8的值  
		int plusRst = new Plus().interpret(new Context(9, 2));
        int minusRst = new Minus().interpret((new Context(plusRst, 8)));  
        System.out.println(minusRst);  
    } 
}
