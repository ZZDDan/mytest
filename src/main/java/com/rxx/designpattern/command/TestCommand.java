package com.rxx.designpattern.command;
/**
 * @Title      :TestCommand
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午11:08:38
 */
public class TestCommand {
	public static void main(String[] args) {  
        Receiver receiver = new Receiver();  
        Command cmd = new MyCommand(receiver);  
        Invoker invoker = new Invoker(cmd);  
        invoker.action();  
    }  
}
