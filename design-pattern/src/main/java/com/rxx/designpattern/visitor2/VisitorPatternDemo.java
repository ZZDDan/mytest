package com.rxx.designpattern.visitor2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 15:54
 */
public class VisitorPatternDemo{
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
