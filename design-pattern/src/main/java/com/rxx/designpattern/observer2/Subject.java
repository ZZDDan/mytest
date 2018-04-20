package com.rxx.designpattern.observer2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 17:11
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
