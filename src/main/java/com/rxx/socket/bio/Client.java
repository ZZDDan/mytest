package com.rxx.socket.bio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :Client
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月6日 下午5:04:59
 */
public class Client implements Runnable {

	private Socket socket;  
	  
    private String userId;  
  
    private final static String ip = "127.0.0.1";  
    private final static int port = 19000;  
  
    private DataInputStream dis;  
    private DataOutputStream dos;  
  
    private String message;  
  
    private Scanner sc;  
    private String choice;  
  
    private boolean running;  
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");  
  
    public Client() {  
        try {  
            running = true;  
            sc = new Scanner(System.in);  
            SocketAddress socAddress = new InetSocketAddress(ip, port);  
            socket = new Socket();  
            socket.connect(socAddress);  
            socket.setKeepAlive(true);  
  
            if (socket.isConnected()) {  
                userId = socket.getLocalAddress().getHostName() + " " + Thread.currentThread().getId() + " " + sdf.format(new Date());  
                dis = new DataInputStream(socket.getInputStream());  
                dos = new DataOutputStream(socket.getOutputStream());  
                dos.writeUTF(MsgFlag.MSG_ONLINE + userId);  
                System.out.println(userId + ",连接成功..");  
            }  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 关闭客户端socket 
     */  
    private void stop() {  
        try {  
            if (dis != null)  
                dis.close();  
            if (dos != null)  
                dos.close();  
            if (socket != null)  
                socket.close();  
              
            if(running ==true)running = false;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    private void sendMessage() {  
        String msg = null;  
        System.out.println("请输入消息内容:");  
        if (sc.hasNext()) {  
            msg = sc.nextLine();  
        }  
  
        try {  
            if (msg != null && dos != null) {  
                dos.writeUTF(  
                        MsgFlag.MSG_MESSAGE + "userId:" + userId + "time:" + sdf.format(new Date()) + "Msg:" + msg);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("写数据异常。。。");  
  
        }  
    }  
  
    @Override  
    public void run() {  
        // 轮询读缓冲区数据  
        try {  
              
            while (running) {  
                System.out.println("选择操作：1.发送消息\t 2.停止");  
                if (sc.hasNext()) {  
                    choice = sc.nextLine();  
                }  
                if (choice.equals("1"))  
                    sendMessage();  
                else if (choice.equals("2")) { 
                	dos.writeUTF(MsgFlag.MSG_OFFLINE + userId);
                    stop();  
                    System.out.println("客户端userId：" + userId + "is closed");  
                      
                }  
  
                // 读消息  
                if(running){  
                    if (dis.available() >= 0) {  
                        message = dis.readUTF();  
                        System.out.println(message);  
                        if (message.startsWith(MsgFlag.MSG_Curr_ONLINE_USER)) { // client接收server发送的当前用户信息  
  
                            System.out.println(message.substring(MsgFlag.MSG_Curr_ONLINE_USER.length()));  
                        } else if (message.startsWith(MsgFlag.MSG_MESSAGE)) {  
                            System.out.println(message.substring(MsgFlag.MSG_MESSAGE.length()));  
                        }  
                    }  
                }  
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
            // System.out.println("度数据异常....,自动关闭客户端");  
        }  
    }  

    public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		exec.execute(new Client());
	}
}
