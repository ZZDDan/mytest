package com.rxx.designpattern.chain2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 11:03
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
