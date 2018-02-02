package com.rxx.designpattern.bridge2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 17:40
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
