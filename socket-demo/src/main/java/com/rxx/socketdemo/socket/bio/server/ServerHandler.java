package com.rxx.socketdemo.socket.bio.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.msg.MsgHandler;

/**
 * @Title      :ServerHandler
 * @Description:用于处理一个客户端的Socket链路
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月16日 下午4:05:52
 */
public class ServerHandler implements Runnable {
    
    private Socket socket;
    public ServerHandler(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            
            while(true){
                // 通过 BufferedReader读取一行  
                // 如果已经读到输入流尾部，返回null,退出循环  
                // 如果得到非空值，就尝试计算结果并返回  
                String msg = null; 
                if((msg = reader.readLine()) == null){
                    break;
                }
                if(BaseConstant.QUIT.equals(msg)){
                    BIOSocketServer.clientCount --;
                    System.out.println(BaseConstant.CLIENT_COUNT_MINUS_MSG + BIOSocketServer.clientCount);
                    return;
                }
                byte[] result = MsgHandler.acceptMsg(msg);
                writer.println(new String(result, BaseConstant.CHARSET));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }finally{
            // 一些必要的清理工作  
            if(writer != null){
                writer.close();
                writer = null;
            }
            if(reader != null ){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                reader = null;
            }
            if(socket != null ){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
