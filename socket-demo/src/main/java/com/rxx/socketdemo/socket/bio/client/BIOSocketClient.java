package com.rxx.socketdemo.socket.bio.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.socket.IOSocketClient;

/**
 * @Title      :Client
 * @Description:阻塞式I/O创建的客户端 
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月6日 下午5:04:59
 */
public class BIOSocketClient implements IOSocketClient {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    
    @Override
    public void start(String addr, int port) throws IOException {
        socket = new Socket(addr, port);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public boolean sendMsg(String msg) {
        // 不能清理资源，因为关闭数据流的时候 socket 也会被关闭 
        try {
            writer.println(msg);
            String result = reader.readLine();
            System.out.println(BaseConstant.CLIENT_ACCEPTED_MSG + result);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void close() {
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(reader != null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(writer != null){
            writer.close();
        }
    }
}
