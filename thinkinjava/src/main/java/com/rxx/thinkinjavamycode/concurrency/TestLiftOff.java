package com.rxx.thinkinjavamycode.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/5 10:38
 */
public class TestLiftOff {

    public static void main(String[] args) {
        int len = 5;
        for(int i = 0; i < len; i++) {
            new Thread(new LiftOff()).start();
        }

    }
}
