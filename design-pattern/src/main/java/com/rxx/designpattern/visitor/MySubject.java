package com.rxx.designpattern.visitor;
/**
 * @Title      :MySubject
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午2:29:47
 */
public class MySubject implements Subject {  
  
    @Override  
    public void accept(Visitor visitor) {  
        visitor.visit(this);  
    }  
  
    @Override  
    public String getSubject() {  
        return "love";  
    }  
}
