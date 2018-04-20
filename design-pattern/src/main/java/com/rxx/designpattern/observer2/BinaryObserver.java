package com.rxx.designpattern.observer2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 17:12
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}