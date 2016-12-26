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
 * jdbc������
 * @author andy
 *
 */
public class JdbcUtil1 {
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String driverClass=null;
	
	//��̬����� ��(ֻ����һ�� )ע����������
	static{
		
		try {
			//��ȡdb.properties�ļ�
			Properties prop=new Properties();
			/**
			 *  . ����java�������е�Ŀ¼
			 *  ��java��Ŀ�£�. java���������Ŀ¼����Ŀ�ĸ�Ŀ¼��ʼ
			 *  ��web��Ŀ�£�  . java����Ķ�����Ŀ¼��tomcat/binĿ¼��ʼ
			 *  ���Բ���ʹ�õ�.
			 */
			//FileInputStream in = new FileInputStream("./src/db.properties");
			
			/**
			 * ʹ����·���Ķ�ȡ��ʽ
			 *  / : б�ܱ�ʾclasspath�ĸ�Ŀ¼
			 *     ��java��Ŀ�£�classpath�ĸ�Ŀ¼��binĿ¼��ʼ
			 *     ��web��Ŀ�£�classpath�ĸ�Ŀ¼��WEB-INF/classesĿ¼��ʼ
			 */
			InputStream in = JdbcUtil1.class.getResourceAsStream("/db.properties");
			
			prop.load(in);
			//��ȡ��Ϣ
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driverClass=prop.getProperty("driverClass");
			
		Class.forName(driverClass);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("ע����������ʧ��");
		
	}
	}
	/**
	 * ��ȡ��ȡ���Ӷ���ķ���
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
     * �ͷ���Դ
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
    	if(state!=null){   // �п���Ϊ�˱����ָ���쳣
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
    	
    	if(state!=null){   // �п���Ϊ�˱����ָ���쳣
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
