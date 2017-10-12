package com.rxx.designpattern.singleton;

/**
 * 第一种（懒汉，线程不安全）
 * Created by zhang on 2017/10/11.
 */
public class Singleton1 {

    private static Singleton1 instance;
    private Singleton1(){}

    public static Singleton1 getInstance() {
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
