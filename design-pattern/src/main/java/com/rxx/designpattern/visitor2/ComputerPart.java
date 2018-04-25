package com.rxx.designpattern.visitor2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 15:52
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
