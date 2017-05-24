package com.rxx.socketdemo.msg;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.exception.ServiceException;

/**
 * @Title      :MsgHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月19日 上午9:21:02
 */
public class MsgHandler {

    /**
     * 根据 msg 执行相应的操作，msg 的类型与枚举类型的实例的未知有关
     * @param msg
     * @return
     */
    public static byte[] acceptMsg(String msg) {
        
        String[] split = msg.split("#");
        if(split.length < 2){
            String errMsg = BaseConstant.SEND_MSG_ERROR;
            new ServiceException(errMsg);
            return errMsg.getBytes();
        }
        
        String type = split[0];
        String content = split[1];
        
        int t = Integer.parseInt(type);
        MsgType msgType = MsgType.values()[t-1];
        System.out.println(BaseConstant.MSG_TYPE + msgType + BaseConstant.MSG_CONTENT + content);
        
        return msgType.interpret(content);
    }

    
}
