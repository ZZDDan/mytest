package com.rxx.designpattern.builder2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 15:38
 */
public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
