package com.rxx.designpattern.decorator2;

import com.rxx.designpattern.abstractfactory2.Shape;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 18:01
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
