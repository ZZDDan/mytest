package com.rxx.socketdemo.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Title      :SocketConfig
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月10日 下午4:39:35
 */
public class SocketConfig {
    private String ip;
    private int port;
    private Class<IOSocketClient> clientClass; 
    private Class<IOSocketServer> serverClass;
    private static SocketConfig socketConfig;
    
    @SuppressWarnings("unchecked")
    private SocketConfig() {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("D:\\rundata\\idea_workspace\\mytest\\socketdemo\\src\\main\\resources\\socket-demo.properties"));
            properties.load(fis);
            ip = properties.get("ip") + "";
            port = Integer.parseInt(properties.get("port") + "");
            String socketClient = properties.get("socketClient") + "";
            String socketServer = properties.get("socketServer") + "";
            clientClass = (Class<IOSocketClient>) Class.forName(socketClient);
            serverClass = (Class<IOSocketServer>) Class.forName(socketServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static SocketConfig getInstance(){
        if(socketConfig == null){
            socketConfig = new SocketConfig();
        }
        return socketConfig;
    }
    
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public Class<IOSocketClient> getClientClass() {
        return clientClass;
    }
    public void setClientClass(Class<IOSocketClient> clientClass) {
        this.clientClass = clientClass;
    }
    public Class<IOSocketServer> getServerClass() {
        return serverClass;
    }
    public void setServerClass(Class<IOSocketServer> serverClass) {
        this.serverClass = serverClass;
    }
}
