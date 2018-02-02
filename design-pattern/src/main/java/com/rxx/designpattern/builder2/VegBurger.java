package com.rxx.designpattern.builder2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 15:38
 */
public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
