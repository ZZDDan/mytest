package com.rxx.designpattern.bridge2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 17:39
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}