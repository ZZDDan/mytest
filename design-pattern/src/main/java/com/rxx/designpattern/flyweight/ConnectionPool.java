package com.rxx.designpattern.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @Title      :ConnectionPool
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月9日 下午6:04:25
 */
public class ConnectionPool {
	private Vector<Connection> pool;  
    
    /*公有属性*/  
    private String url = "jdbc:mysql://localhost:3306/test";  
    private String username = "root";  
    private String password = "root";  
    private String driverClassName = "com.mysql.jdbc.Driver";  
  
    private int poolSize = 100;  
    Connection conn = null;  
    
    // ====== 单例模式 创建连接池对象 start ======== 
    private static class SingletonFactory {  
        private static ConnectionPool instance = new ConnectionPool();  
    }    
    /* 获取工厂实力实例 */  
    public static ConnectionPool getInstance() {  
        return SingletonFactory.instance;  
    }  
    // ====== 单例模式 创建连接池对象 end ======== 
    
    /*构造方法，做一些初始化工作*/  
    private ConnectionPool() {  
        pool = new Vector<Connection>(poolSize);  
  
        for (int i = 0; i < poolSize; i++) {  
            try {  
                Class.forName(driverClassName);  
                conn = DriverManager.getConnection(url, username, password);  
                pool.add(conn);  
            } catch (ClassNotFoundException e) {  
                e.printStackTrace();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /* 返回连接到连接池 */  
    public synchronized void release() {  
        pool.add(conn);  
    }  
  
    /* 返回连接池中的一个数据库连接 */  
    public synchronized Connection getConnection() {  
        if (pool.size() > 0) {  
            Connection conn = pool.get(0);  
            pool.remove(conn);  
            return conn;  
        } else {  
            return null;  
        }  
    }  
}
