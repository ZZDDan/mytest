package com.rxx.designpattern.observer2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 17:13
 */
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
