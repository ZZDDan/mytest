package com.rxx.designpattern.chain2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 11:03
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}