package com.rxx.designpattern.memento2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 14:50
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
