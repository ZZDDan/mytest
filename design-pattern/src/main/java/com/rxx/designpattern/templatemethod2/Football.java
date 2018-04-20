package com.rxx.designpattern.templatemethod2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 15:02
 */
public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}