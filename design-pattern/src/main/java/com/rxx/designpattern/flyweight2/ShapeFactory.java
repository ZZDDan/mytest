package com.rxx.designpattern.flyweight2;

import java.util.HashMap;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 16:46
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }

}
