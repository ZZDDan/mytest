package com.rxx.designpattern.abstractfactory2;

import com.rxx.designpattern.abstractfactory2.Shape;

/**
 * @author :zhangdan
 * @Description:创建形状实现接口的实体类
 * @Company :
 * @date :2018/2/2 13:48
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
