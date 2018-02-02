package com.rxx.designpattern.adapter2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 17:15
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
