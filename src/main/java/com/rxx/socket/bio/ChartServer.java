package com.rxx.socket.bio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title      :ChartServer
 * @Description:client-server 服务端是做客户端的请求响应的，分清客户端和服务端的功能和作用
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月6日 下午5:03:34
 */
public class ChartServer {
	private ExecutorService executorService; // 执行服务  
    private ServerSocket serverSocket; // 服务端socket  
    private int port; // 端口  
  
    private boolean quit = false; // 是否退出  
    private List<SocketTask> socketTasks = null; // 连接客户端socket集合  
    private Socket socket = null; // 临时socket  
    private SocketTask socketTask = null;  
  
    public ChartServer() {  
    }  
  
    /** 
     * 初始化 
     *  
     * @param port端口 
     */  
    public ChartServer(int port) {  
        this.port = port;  
        socketTasks = new ArrayList<SocketTask>();  
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 20);  
    }  
  
    public void start() {  
        try {  
            serverSocket = new ServerSocket(port);  
            System.out.println("等待客户端用户连接...");  
        } catch (IOException e) {  
            System.out.println(e.getMessage() + "5...");  
            e.printStackTrace();  
        }  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                while (!quit) {  
                    try {  
                        socket = serverSocket.accept();  
                        socketTask = new SocketTask(socket);  
                        executorService.execute(socketTask); // 放入线程池并执行  
                        socketTasks.add(socketTask);  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                        System.out.println(e.getMessage());  
                    }  
                }  
            }  
        }).start();  
  
    }  
    /** 
     * 关闭服务器 
     */  
    public void stop() {  
        this.quit = true;  
        try {  
            if (socketTasks.size() != 0) {  
                for (SocketTask st : socketTasks) {  
  
                    if (st.dis != null)  
                        st.dis.close();  
                    if (st.dos != null)  
                        st.dos.close();  
                    if (st.socket != null)  
                        st.socket.close();  
                }  
            }  
            socketTasks.clear();  
            if (serverSocket != null)  
                serverSocket.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println(e.getMessage() + "+1...");  
        }  
    }  
  
    /** 
     * 服务端开启的临时socket，供与客户端socket连接 
     *  
     * @author Administrator 
     * 
     */  
    private class SocketTask implements Runnable {  
  
        private Socket socket;  
        private DataInputStream dis;  
        private DataOutputStream dos;  
        private String message;  
        private String userId;  
  
        public SocketTask(Socket socket) {  
            this.socket = socket;  
            try {  
                // socket.setSoTimeout(5*1000);  
                socket.setKeepAlive(true);  
  
                dos = new DataOutputStream(socket.getOutputStream());  
                dis = new DataInputStream(socket.getInputStream());  
            } catch (IOException e) {  
                e.printStackTrace();  
                System.out.println(e.getMessage());  
            }  
        }  
  
        /** 
         * 发送消息 
         *  
         * @param message 
         */  
        public void sendMessage(String msg) {  
            try {  
                if (msg != null && dos != null)  
                    dos.writeUTF(msg);  
            } catch (IOException e) {  
                System.out.println(e.getMessage() + "3...");  
                e.printStackTrace();  
            }  
        }  
  
        /** 
         * 关闭socket 
         */  
        public void stopSocket() {  
            try {  
                if (dis != null)  
                    dis.close();  
                if (dos != null)  
                    dos.close();  
                if (socket != null)  
                    socket.close();  
                  
                socketTasks.remove(this);  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
  
        @Override  
        public void run() {  
            try {  
                while (true) {  
                    if (dis == null)  
                        return;  
                    message = dis.readUTF();  
                    System.out.println("accetpt:" + message);  
                    if (message.startsWith(MsgFlag.MSG_ONLINE)) { // client登录消息到server  
                        userId = message.substring(MsgFlag.MSG_ONLINE.length());  
                        int onlineNums = socketTasks.size();  
                        System.out.println("当前在线人数:" + onlineNums);  
                        if (onlineNums > 0) {  
                            for (SocketTask st : socketTasks) {  
                                  
                                if (st != this && st.socket.getKeepAlive())  
                                    this.sendMessage(MsgFlag.MSG_Curr_ONLINE_USER + st.userId); // 将当前用户信息发送到刚连接的client  
                            }  
                        } else { // 当前只有自己在线  
                            this.sendMessage(MsgFlag.MSG_MESSAGE + "只有自己在线...");  
                        }  
                    } else if (message.startsWith(MsgFlag.MSG_MESSAGE)) { // client发送消息到server  
                        int onlineNums = socketTasks.size();  
                        System.out.println("当前在先人数:" + onlineNums);  
  
                        if (onlineNums > 0) {  
                            for (SocketTask st : socketTasks) {  
                                if (st != this && st.socket.getKeepAlive())  
                                    st.sendMessage(message);  
                            }  
                        } else { // 只有自己在线  
                            this.sendMessage(MsgFlag.MSG_MESSAGE + "只有自己在线...");  
                        }  
                    } else if (message.startsWith(MsgFlag.MSG_OFFLINE)) {  
                        stopSocket();  
                    }  
  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
                System.out.println(e.getMessage() + "+1。。。");  
                  
            }finally {  
                stopSocket();  
            }  
        }  
    }  
    
    public static void main(String[] args) {
		ChartServer chartServer = new ChartServer(19000);
		chartServer.start();
	}
}
