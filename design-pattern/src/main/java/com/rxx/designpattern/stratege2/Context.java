package com.rxx.designpattern.stratege2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/19 17:39
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
