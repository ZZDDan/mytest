package com.rxx.designpattern.observer2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 17:12
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
