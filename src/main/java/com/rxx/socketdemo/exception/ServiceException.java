package com.rxx.socketdemo.exception;
/**
 * @Title      :MsgErrorException
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月19日 上午9:29:58
 */
public class ServiceException extends Exception {

    /**  */
    private static final long serialVersionUID = 1L;

    public ServiceException(){
        super();
    }
    
    public ServiceException(String msg){
        super(msg);
    }
    
    public ServiceException(String msg, Exception e){
        super(msg, e);
    }
    
}
