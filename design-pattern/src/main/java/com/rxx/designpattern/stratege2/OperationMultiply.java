package com.rxx.designpattern.stratege2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/19 17:37
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
