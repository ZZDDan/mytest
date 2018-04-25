package com.rxx.designpattern.chain2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 11:02
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}