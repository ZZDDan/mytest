package com.rxx.designpattern.state2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 15:21
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Stop State";
    }
}
