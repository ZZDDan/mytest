package com.rxx.designpattern.visitor2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 15:52
 */
public class Monitor  implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
