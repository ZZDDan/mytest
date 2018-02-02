package com.rxx.designpattern.factorymethod2;

import com.rxx.designpattern.abstractfactory2.Circle;
import com.rxx.designpattern.abstractfactory2.Rectangle;
import com.rxx.designpattern.abstractfactory2.Shape;
import com.rxx.designpattern.abstractfactory2.Square;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 14:45
 */
public class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
