package com.rxx.designpattern.command2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 13:51
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ",Quantity:" + quantity + " ]bought ");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ",Quantity:" + quantity + " ]sold ");
    }
}
