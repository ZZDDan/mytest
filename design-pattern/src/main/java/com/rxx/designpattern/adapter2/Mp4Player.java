package com.rxx.designpattern.adapter2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 17:16
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
