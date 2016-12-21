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

import cn.wistron.bean.SMBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.SMDao;
import cn.wistron.dao.SensorDao;
import cn.wistron.utils.MusicDemo;

import com.opensymphony.xwork2.ActionSupport;

public class HttpTest1 extends ActionSupport {
	private String value;
	private String Sensor_ID= null;
	private String Sensor_Value=null;
    private String Sensor_Status=null;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String execute() throws Exception{
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		//解决乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取输出
		ServletOutputStream out =response.getOutputStream();
		String[] split = value.split(";");
		for(int i=0;i<split.length;i++){
			String[] split2 = (split[i]+"").split(",");
			Sensor_ID=split2[0];
			Sensor_Value=split2[1];
		    Sensor_Status=split2[2];
		    SensorBean bean = new SensorDao().Getbean(Integer.parseInt(Sensor_ID));
		    bean.setSensor_Value(Sensor_Value);
		    SMBean smbean = new SMDao().getBean1(Integer.parseInt(Sensor_ID));
		    if(Integer.parseInt(Sensor_ID)==smbean.getSM_SensorID()){
		    if(Integer.parseInt(Sensor_Value)>smbean.getMotion_Value()){
		    	new MusicDemo().SoundUtils(smbean.getMotion_Msg());
		    }
		    }
			bean.setSensor_Status(Boolean.parseBoolean(Sensor_Status));
			new SensorDao().update(bean);

		}
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
		System.out.println(Sensor_ID);

		System.out.println(Sensor_Value);
		System.out.println(Sensor_Status);
		out.write("数据已经收到".getBytes());
		return null;
	}
	
}
