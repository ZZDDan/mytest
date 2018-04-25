package com.rxx.designpattern.mediator2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 16:08
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
