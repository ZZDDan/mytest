package com.rxx.designpattern.builder2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 15:33
 */
public abstract class ColdDrink implements Item {
    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
