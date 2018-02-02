package com.rxx.designpattern.bridge2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 17:42
 */
public class BridgeTest {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
