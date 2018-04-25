package com.rxx.designpattern.mediator2;

import java.util.Date;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 16:08
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() +"] : " + message);
    }
}
