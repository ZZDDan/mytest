package com.rxx.designpattern.visitor;
/**
 * @Title      :TestVisitor
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午2:30:30
 */
public class TestVisitor {
	public static void main(String[] args) {  
        Visitor visitor = new MyVisitor();  
        Subject sub = new MySubject();  
        sub.accept(visitor);      
    }  
}
