package com.rxx.designpattern.proxy;
/**
 * @Title      :Proxy
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午4:57:36
 */
public class Proxy  implements Sourceable {  
  
    private Source source;  
    public Proxy(){  
        super();  
        this.source = new Source();  
    }  
    @Override  
    public void method() {  
        before();  
        source.method();  
        atfer();  
    }  
    private void atfer() {  
        System.out.println("after proxy!");  
    }  
    private void before() {  
        System.out.println("before proxy!");  
    }  
}  
