package com.rxx.designpattern.visitor;
/**
 * @Title      :MyVisitor
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午2:28:32
 */
public class MyVisitor implements Visitor{
	@Override  
    public void visit(Subject sub) {  
        System.out.println("visit the subject："+sub.getSubject());  
    }  
}
