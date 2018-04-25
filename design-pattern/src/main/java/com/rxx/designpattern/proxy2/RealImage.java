package com.rxx.designpattern.proxy2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 17:07
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}