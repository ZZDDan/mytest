package com.rxx.designpattern.interpret2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 16:21
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}
