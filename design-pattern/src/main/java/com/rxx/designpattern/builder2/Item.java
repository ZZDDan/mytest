package com.rxx.designpattern.builder2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 15:30
 */
public interface Item {
    String name();
    float price();
    Packing packing();
}
