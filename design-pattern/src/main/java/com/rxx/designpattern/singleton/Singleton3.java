package com.rxx.designpattern.singleton;

/**
 *  第三种（饿汉）
 * Created by zhang on 2017/10/11.
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3(){}
    public static Singleton3 getInstance(){
        return instance;
    }
}
