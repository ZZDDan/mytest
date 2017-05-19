package com.rxx.designpattern.adapter;
/**
 * @Title      :Wrapper
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午3:54:17
 */
public class Wrapper implements Targetable {  
  
    private Source source;  
      
    public Wrapper(Source source){  
        super();  
        this.source = source;  
    }  
    @Override  
    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
  
    @Override  
    public void method1() {  
        source.method1();  
    }  
}  