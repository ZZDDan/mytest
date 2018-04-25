package com.rxx.designpattern.mediator2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 16:09
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
