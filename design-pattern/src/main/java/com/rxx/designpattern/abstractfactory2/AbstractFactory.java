package com.rxx.designpattern.abstractfactory2;

/**
 * @author :zhangdan
 * @Description:为 Color 和 Shape 对象创建抽象类来获取工厂。
 * @Company :
 * @date :2018/2/2 14:03
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
}
