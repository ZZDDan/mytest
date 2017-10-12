package com.rxx.designpattern.singleton;

/**
 * 第七种（双重校验锁）
 * Created by zhang on 2017/10/11.
 */
public class Singleton7 {
    private static Singleton7 instance;

    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        if (instance == null) {
            synchronized (Singleton7.class) {
                if (instance == null) {
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }

}
