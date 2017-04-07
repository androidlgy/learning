package cn.wistron.utils;
import java.io.BufferedInputStream;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.net.InetSocketAddress;  
import java.net.Socket;  
import java.net.SocketAddress;  
import java.net.URLEncoder;  
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;

import cn.wistron.bean.SensorBean;
import cn.wistron.dao.SensorDao;
  
public class TestDemo {  
    private int port;  
    private String host;  
    private Socket socket;  
    private BufferedReader bufferedReader;  
    private BufferedWriter bufferedWriter;  
    public TestDemo(String host, int port) {  
        socket = new Socket();  
        this.host = host;  
        this.port = port;  
    }  
      
    public void sendGet() throws IOException  
    {  
        String path = "/system_demo/HttpTest1";  
        SocketAddress dest = new InetSocketAddress(this.host, this.port);  
        socket.connect(dest);  
        OutputStreamWriter streamWriter = new OutputStreamWriter(socket.getOutputStream());  
        bufferedWriter = new BufferedWriter(streamWriter);  
          
        bufferedWriter.write("GET " + path + " HTTP/1.1\r\n");  
        bufferedWriter.write("Host: " + this.host + "\r\n");  
        bufferedWriter.write("\r\n");  
        bufferedWriter.flush();  
          
        BufferedInputStream streamReader = new BufferedInputStream(socket.getInputStream());  
        bufferedReader = new BufferedReader(new InputStreamReader(streamReader, "utf-8"));  
        String line = null;  
        while((line = bufferedReader.readLine())!= null)  
        {  
            System.out.println(line);  
        }  
        bufferedReader.close();  
        bufferedWriter.close();  
        socket.close();  
    }  
      
    public void sendPost() throws IOException, JSONException  
    {  
        String path = "/system_demo/HttpTest1.action";  
        String value ="value=1,59,true;2,54,true;3,76,true;4,65,true;";
        		/*URLEncoder.encode("name", "utf-8") + "=" + URLEncoder.encode("gloomyfish", "utf-8") + "&" +  
                        URLEncoder.encode("age", "utf-8") + "=" + URLEncoder.encode("32", "utf-8");*/  
        // String data = "name=zhigang_jia";  
 /*       String sql="select * from sensormanager";
     Connection conn=null;
      Statement stat=null;
      ResultSet rs=null;
        String value="";
        try {
		     conn = JdbcUtil1.getConnection();
			 stat = conn.createStatement();
		     rs = stat.executeQuery(sql);
		     value=RsToJson.resultSetToJson(rs);
		     value=new String(value.getBytes(),"utf-8");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}*/
        SocketAddress dest = new InetSocketAddress(this.host, this.port);  
        socket.connect(dest);  
        OutputStreamWriter streamWriter = new OutputStreamWriter(socket.getOutputStream(), "utf-8");  
        bufferedWriter = new BufferedWriter(streamWriter);  
          
        bufferedWriter.write("POST " + path + " HTTP/1.1\r\n");  
        bufferedWriter.write("Host: " + this.host +":8080"+ "\r\n");  
        bufferedWriter.write("Content-Length: " + value.length() + "\r\n");  
        bufferedWriter.write("Content-Type:application/x-www-form-urlencoded");  
        bufferedWriter.write("\r\n"); 
        bufferedWriter.write("\r\n"); 
        bufferedWriter.write(value);  
        bufferedWriter.flush();  
        bufferedWriter.write("\r\n");  
        bufferedWriter.flush();  
          
        BufferedInputStream streamReader = new BufferedInputStream(socket.getInputStream());  
        bufferedReader = new BufferedReader(new InputStreamReader(streamReader, "utf-8"));  
        String line = null;  
        while((line = bufferedReader.readLine())!= null)  
        {  
            System.out.println(line);  
        }  
        bufferedReader.close();  
        bufferedWriter.close();  
        socket.close();  
    }  
      
    public static void main(String[] args) throws JSONException  
    {  
        TestDemo td = new TestDemo("127.0.0.1",8080);  
        try {  
            // td.sendGet(); //send HTTP GET Request  
              
            td.sendPost(); // send HTTP POST Request  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}
 