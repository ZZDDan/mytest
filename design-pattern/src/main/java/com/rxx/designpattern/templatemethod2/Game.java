package com.rxx.designpattern.templatemethod2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 15:01
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板
    public final void play() {

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
