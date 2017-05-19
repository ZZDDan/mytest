package com.rxx.designpattern.factorymethod;
/**
 * @Title      :MailSender
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月3日 上午11:19:59
 */
public class MailSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  
