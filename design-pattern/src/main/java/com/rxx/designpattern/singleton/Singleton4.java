package com.rxx.designpattern.singleton;

/**
 * 第四种（饿汉，变种）
 * Created by zhang on 2017/10/11.
 */
public class Singleton4 {
    private static Singleton4 instance;
    static{
        instance = new Singleton4();
    }
    private Singleton4(){}
    public static Singleton4 getInstance(){
        return instance;
    }
}
