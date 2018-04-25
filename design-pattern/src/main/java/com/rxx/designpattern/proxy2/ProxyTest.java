package com.rxx.designpattern.proxy2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 17:08
 */
public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //图像将从磁盘加载
        image.display();
        System.out.println("");
        //图像将无法从磁盘加载
        image.display();
    }

}
