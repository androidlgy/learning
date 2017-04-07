package cn.wistron.action;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.runner.Request;

import sun.security.jca.GetInstance;

import cn.wistron.bean.AlarmBean;
import cn.wistron.bean.Data;
import cn.wistron.bean.SMBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.AlarmDao;
import cn.wistron.dao.SMDao;
import cn.wistron.dao.SensorDao;
import cn.wistron.utils.JdbcUtils;
import cn.wistron.utils.MusicDemo;

import com.opensymphony.xwork2.ActionSupport;

public class HttpTest1 extends ActionSupport {
	private String value;
	private String Sensor_ID= null;
	private String Sensor_Value=null;
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
		response.setContentType("application/x-www-form-urlencoded;charset=utf-8");
		
		//获取输出
		ServletOutputStream out =response.getOutputStream();
		System.out.println(value.length());
		//解析为map
	  try {
                ObjectMapper objectMapper = new ObjectMapper();
		        List<LinkedHashMap<String, Object>> list = objectMapper.readValue(value, List.class);
		        System.out.println(list.size());
		        for (int i = 0; i < list.size(); i++) {
		            Map<String, Object> map = list.get(i);
		            Data data = new Data();
		            String Museum_Name=(String) map.get("Museum_Name");
		            data.setMuseum_Name(Museum_Name);
		            data.setBuilding_Name((String) map.get("Building_Name"));
		            String Room_Name=(String) map.get("Room_Name");
		            data.setRoom_Name(Room_Name);
		            data.setSensor_Name((String) map.get("Sensor_Name"));
		            data.setSensor_ReceiveTime((String) map.get("Sensor_ReceiveTime"));
		            String Sensor_Status=(String) map.get("Sensor_Status");
		            if(Sensor_Status.equals("正常")){
		            	Sensor_Status=1+"";
		            }
		            data.setSensor_Status(Sensor_Status);
		            Sensor_Value=(String) map.get("Sensor_Value");
		            data.setSensor_Value(Sensor_Value);
		            SensorBean bean = new SensorDao().GetFirstBean1("Sensor_Description='"+(String) map.get("Sensor_Name")+"'");
		            if(bean.getSensor_Name()!=null){
		            Sensor_ID = bean.getSensor_ID()+"";
		            if(bean.getMuseum_Name().equals(Museum_Name)&&bean.getStorehouse_Name().equals(Room_Name)){
		      		    final SMBean smbean = new SMDao().getBean1(Integer.parseInt(Sensor_ID));
		      		    if(Integer.parseInt(Sensor_ID)==smbean.getSM_SensorID()){
		      		    if(Integer.parseInt(Sensor_Value)>smbean.getMotion_Value()){
		      		    	AlarmBean alarmBean = new AlarmDao().getBean(Integer.parseInt(Sensor_ID));
		      		    	alarmBean.setAlarm_Thing(alarmBean.getAlarm_Time()+" "+alarmBean.getAlarm_MuseumName()+" "+alarmBean.getAlarm_BuildingName()+alarmBean.getAlarm_SensorName()+" 参数超过阈值");
		      		    	new AlarmDao().addAlarm(alarmBean);
						    MusicDemo.getInstance().SoundUtils(smbean.getMotion_Msg());

		      		    }
		      		    }
		            	String sql="update sensormanager set Sensor_Value=?,Sensor_ReceiveTime=?,Sensor_Status=? where Sensor_ID=?";
		            	try {
							QueryRunner runner = JdbcUtils.getQueryRunner();
							runner.update(sql,data.getSensor_Value(),data.getSensor_ReceiveTime(),data.getSensor_Status(),Sensor_ID);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		            else{
		            	out.write("数据有误".getBytes());
		            }
		        }
		        }
		    } catch (JarException e) {
		        e.printStackTrace();
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
/*		System.out.println(Sensor_ID);

		System.out.println(Sensor_Value);
		System.out.println(Sensor_Status);*/
		out.write("true".getBytes());
		return null;
	}
	
	
}
