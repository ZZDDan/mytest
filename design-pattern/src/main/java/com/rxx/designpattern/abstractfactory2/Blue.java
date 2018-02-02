package com.rxx.designpattern.abstractfactory2;

/**
 * @author :zhangdan
 * @Description:创建颜色实现接口的实体类
 * @Company :
 * @date :2018/2/2 13:59
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
