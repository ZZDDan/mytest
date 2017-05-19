package com.rxx.designpattern.command;
/**
 * @Title      :MyCommand
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午11:07:31
 */
public class MyCommand implements Command {  
  
    private Receiver receiver;  
      
    public MyCommand(Receiver receiver) {  
        this.receiver = receiver;  
    }  
  
    @Override  
    public void exe() {  
        receiver.action();  
    }  
}