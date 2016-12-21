package cn.wistron.action;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.junit.runner.Request;

import cn.wistron.bean.SensorBean;
import cn.wistron.dao.SensorDao;

import com.opensymphony.xwork2.ActionSupport;

public class HttpTest extends ActionSupport {
	private String Sensor_ID;
	private String Sensor_Value;
	private String Sensor_Status;
	public String getSensor_ID() {
		return Sensor_ID;
	}
	public void setSensor_ID(String sensor_ID) {
		Sensor_ID = sensor_ID;
	}
	public String getSensor_Value() {
		return Sensor_Value;
	}
	public void setSensor_Value(String sensor_Value) {
		Sensor_Value = sensor_Value;
	}
	public String getSensor_Status() {
		return Sensor_Status;
	}
	public void setSensor_Status(String sensor_Status) {
		Sensor_Status = sensor_Status;
	}

	public String execute() throws Exception{
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		//解决乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取输出
		ServletOutputStream out =response.getOutputStream();
		
		SensorBean bean = new SensorDao().Getbean(Integer.parseInt(Sensor_ID));
		/* Date date=null;
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    date= sdf.parse(Sensor_ReceiveTime);  
		}  
		catch (ParseException e)  
		{  
		    System.out.println(e.getMessage());  
		}
		bean.setSensor_ReceiveTime(date);*/
		/*Date date = new Date();//获得系统时间.
*/		 
  
     
		bean.setSensor_Value(Sensor_Value);

		bean.setSensor_Status(Boolean.parseBoolean(Sensor_Status));
		new SensorDao().update(bean);
		
		System.out.println(Sensor_ID);

		System.out.println(Sensor_Value);
		System.out.println(Sensor_Status);
		out.write("数据已经收到".getBytes());
		return null;
	}
	
}
