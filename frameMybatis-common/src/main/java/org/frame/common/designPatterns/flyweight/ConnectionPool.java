package org.frame.common.designPatterns.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 享元模式
 * 主要目的是实现对象的共享，即共享池
 * 通常与工厂模式一起使用。
 * @author cjshen
 *
 */
public class ConnectionPool {
	
	private Vector<Connection> pool;
	
	//公有属性
	private String url = "jdbc:mysql://10.129.220.15:3316/express";  
    private String username = "ytuat";  
    private String password = "ytuat";  
    private String driverClassName = "com.mysql.jdbc.Driver";  
    
    
    private int poolSize = 10;  
    private static ConnectionPool instance = null;  
    Connection conn = null;  
    
    
    public ConnectionPool(int poolSize){
    	this.poolSize = poolSize;
    	pool = new Vector<Connection>(poolSize);
    	
    	for(int i=0;i<poolSize;i++){
    		try {
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url,username,password);
				pool.add(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {  
                e.printStackTrace();  
            }  
    		
    		
    	}
    	
    }
    
    /* 返回连接到连接池 */ 
    public synchronized void release(){
    	pool.add(conn);
    }
    
    
    /* 返回连接池中的一个数据库连接 */  
    public synchronized Connection getConnection(){
    	if(pool.size()>0){
    		Connection conn = pool.get(0);
    		pool.remove(conn);
    		return conn;
    	}else{
    		return null;
    	}
    }
    
    

}
