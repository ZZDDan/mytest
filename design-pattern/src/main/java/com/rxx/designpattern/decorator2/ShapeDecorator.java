package com.rxx.designpattern.decorator2;

import com.rxx.designpattern.abstractfactory2.Shape;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 18:00
 */
public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
