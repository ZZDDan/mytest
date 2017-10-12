package com.rxx.designpattern.singleton;

/**
 * 第二种（懒汉，线程安全）
 * Created by zhang on 2017/10/11.
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
