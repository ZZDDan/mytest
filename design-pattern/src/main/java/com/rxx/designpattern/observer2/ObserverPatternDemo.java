package com.rxx.designpattern.observer2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 17:13
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
