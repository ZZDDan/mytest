package com.rxx.designpattern.interpret;
/**
 * @Title      :Plus
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午3:05:24
 */
public class Plus implements Expression {  
    @Override  
    public int interpret(Context context) {  
        return context.getNum1()+context.getNum2();  
    }  
}
