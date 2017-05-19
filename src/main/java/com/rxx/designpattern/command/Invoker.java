package com.rxx.designpattern.command;
/**
 * @Title      :Invoker
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午11:08:47
 */
public class Invoker {
	private Command command;  
    
    public Invoker(Command command) {  
        this.command = command;  
    }  
  
    public void action(){  
        command.exe();  
    }
}
