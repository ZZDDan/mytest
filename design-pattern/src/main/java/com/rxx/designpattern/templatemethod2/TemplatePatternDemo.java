package com.rxx.designpattern.templatemethod2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/20 15:02
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
