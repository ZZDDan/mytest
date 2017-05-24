package com.rxx.socketdemo.socket;

import java.io.IOException;
import java.util.Scanner;

import com.rxx.socketdemo.concurrent.ThreadPoolTaskExecutor;

/**
 * @Title      :SocketExecutor
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月10日 下午3:48:09
 */
public class SocketClientManager {
    static IOSocketClient client = null;
    public void start(SocketConfig socketConfig){

        try {
            client = socketConfig.getClientClass().newInstance();
            client.start(socketConfig.getIp(), socketConfig.getPort());
        } catch (InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        SocketConfig socketConfig = SocketConfig.getInstance();
        new SocketClientManager().start(socketConfig);
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.println("功能选择：1. 计算器 \t 2. 读取文件 \t 3. 退出");  
            String msg = scanner.nextLine();
            switch (msg) {
            case "1":
                String expression = "";
                System.out.print("请输入表达式（quit：退出）：");
                while(!"quit".equals(expression = scanner.nextLine())){
                    if("".equals(expression)){
                        continue;
                    }
                    client.sendMsg("1#" + expression);
                    System.out.print("请输入表达式（quit：退出）：");
                }
                break;
            case "2":
                System.out.print("请输入路径（quit：退出）：");
                String path = "";
                while(!"quit".equals(path = scanner.nextLine())){
                    if("".equals(path)){
                        continue;
                    }
                    client.sendMsg("2#" + path);
                    System.out.print("请输入路径（quit：退出）：");
                }
                break;
            case "3":
                client.sendMsg("quit");
                System.out.println("关闭客户端！");
                client.close();
                quit = true;
                break;
            default:
                System.out.println("请选择功能！");
                break;
            }
        } 
        
        ThreadPoolTaskExecutor.getInstance().getThreadPoolExecutor().shutdown();
    }
}
