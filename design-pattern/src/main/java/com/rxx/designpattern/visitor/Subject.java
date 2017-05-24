package com.rxx.designpattern.visitor;
/**
 * @Title      :Subject
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 下午2:28:11
 */
public interface Subject {
	public void accept(Visitor visitor);  
    public String getSubject();  
}
