package com.rxx.socketdemo.bean;
/**
 * @Title      :BaseConstant
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月19日 下午3:14:22
 */
public interface BaseConstant {

    String CHARSET = "UTF-8";
    String QUIT = "quit";
    
    /* ===================== MSG ===================== */
    String CLIENT_COUNT_MINUS_MSG = "关闭了一个客户端，客户端连接的数量：";
    String CLIENT_COUNT_PLUS_MSG = "打开了一个客户端，客户端连接的数量：";
    String CLIENT_ACCEPTED_MSG = "客户端收到消息：";
    String SERVER_STARTED_MSG = "服务器已启动，端口号为:";
    String SERVER_STOPED_MSG = "服务器已关闭";
    
    String SEND_MSG_ERROR = "发送的消息格式有误，请检查格式：type#content";
    String MSG_TYPE = "消息类型：";
    String MSG_CONTENT = "\t 消息内容:";
    String MSG_ALERT = "请选择小于 5M 的文件！";
    
    String READ_MSG_FAIL = "读取数据失败";
}
