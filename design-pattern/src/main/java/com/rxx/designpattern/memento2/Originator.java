package com.rxx.designpattern.memento2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 14:50
 */
public class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}
