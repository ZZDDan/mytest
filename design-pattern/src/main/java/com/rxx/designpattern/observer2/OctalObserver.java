package com.rxx.designpattern.observer2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 17:12
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }
}
