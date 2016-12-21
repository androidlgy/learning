package cn.wistron.utils;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

/**
 * jdbc工具类
 * @author andy
 *
 */
public class JdbcUtil1 {
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String driverClass=null;
	
	//静态代码块 ，(只加载一次 )注册驱动程序
	static{
		
		try {
			//读取db.properties文件
			Properties prop=new Properties();
			/**
			 *  . 代表java命令运行的目录
			 *  在java项目下，. java命令的运行目录从项目的根目录开始
			 *  在web项目下，  . java命令的而运行目录从tomcat/bin目录开始
			 *  所以不能使用点.
			 */
			//FileInputStream in = new FileInputStream("./src/db.properties");
			
			/**
			 * 使用类路径的读取方式
			 *  / : 斜杠表示classpath的根目录
			 *     在java项目下，classpath的根目录从bin目录开始
			 *     在web项目下，classpath的根目录从WEB-INF/classes目录开始
			 */
			InputStream in = JdbcUtil1.class.getResourceAsStream("/db.properties");
			
			prop.load(in);
			//读取信息
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driverClass=prop.getProperty("driverClass");
			
		Class.forName(driverClass);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("注册驱动程序失败");
		
	}
	}
	/**
	 * 抽取获取连接对象的方法
	 */
    public static Connection getConnection(){
    	try {
			Connection conn=DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);		
		}    	
    }
    /**
     * 释放资源
     */
    public static void close(Connection conn,Statement state,ResultSet rs){
    	if(rs!=null){
			try {
				rs.close();  //
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
}
    	if(state!=null){   // 判空是为了避免空指针异常
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
  }
 }
    public static void close(Connection conn,Statement state){
    	
    	if(state!=null){   // 判空是为了避免空指针异常
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
  }
 }
    @Test
 public void test() throws SQLException{
	 Connection conn=new JdbcUtil1().getConnection();
		System.out.println(conn);
		conn.close();
 }
}
