package com.rxx.designpattern.decorator2;

import com.rxx.designpattern.abstractfactory2.Circle;
import com.rxx.designpattern.abstractfactory2.Rectangle;
import com.rxx.designpattern.abstractfactory2.Shape;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 18:03
 */
public class DecoratorTest {
    public static void main(String[] args) {

        Shape circle = new Circle();
        System.out.println("Circle with normal border");
        circle.draw();

        Shape redCircle = new RedShapeDecorator(new Circle());
        System.out.println("\nCircle of red border");
        redCircle.draw();

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
