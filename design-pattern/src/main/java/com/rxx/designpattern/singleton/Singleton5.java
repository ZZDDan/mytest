package com.rxx.designpattern.singleton;

/**
 * 第五种（静态内部类）
 * Created by zhang on 2017/10/11.
 */
public class Singleton5 {
    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    private Singleton5(){}
    public static final Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
