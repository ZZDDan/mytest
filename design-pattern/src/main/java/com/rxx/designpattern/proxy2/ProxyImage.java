package com.rxx.designpattern.proxy2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 17:07
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
