package com.rxx.designpattern.visitor2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 15:53
 */
public interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}
