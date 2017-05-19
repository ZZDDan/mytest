package com.rxx.designpattern.adapter;
/**
 * @Title      :Adapter
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午3:42:14
 */
public class Adapter extends Source implements Targetable {  
  
    @Override  
    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
}  