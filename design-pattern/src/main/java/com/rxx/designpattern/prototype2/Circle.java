package com.rxx.designpattern.prototype2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 16:53
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
