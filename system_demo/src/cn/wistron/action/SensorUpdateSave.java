package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.SensorBean;
import cn.wistron.dao.SensorDao;

public class SensorUpdateSave {
	private String Sensor_ID;
	private String Sensor_StorehouseID;
	private String Sensor_Name;
	private String Sensor_Type;
	private String Sensor_Unit;
	private String Sensor_Description;
	public String getSensor_ID() {
		return Sensor_ID;
	}
	public void setSensor_ID(String sensor_ID) {
		Sensor_ID = sensor_ID;
	}
	public String getSensor_StorehouseID() {
		return Sensor_StorehouseID;
	}
	public void setSensor_StorehouseID(String sensor_StorehouseID) {
		Sensor_StorehouseID = sensor_StorehouseID;
	}
	public String getSensor_Name() {
		return Sensor_Name;
	}
	public void setSensor_Name(String sensor_Name) {
		Sensor_Name = sensor_Name;
	}
	public String getSensor_Type() {
		return Sensor_Type;
	}
	public void setSensor_Type(String sensor_Type) {
		Sensor_Type = sensor_Type;
	}
	public String getSensor_Unit() {
		return Sensor_Unit;
	}
	public void setSensor_Unit(String sensor_Unit) {
		Sensor_Unit = sensor_Unit;
	}
	public String getSensor_Description() {
		return Sensor_Description;
	}
	public void setSensor_Description(String sensor_Description) {
		Sensor_Description = sensor_Description;
	}
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		PrintWriter out = response.getWriter();
		if(session.getAttribute("type")==null){
			out.print("<script language='javascript'>alert('验证不合格，请重新登陆');window.location='Login.jsp'</script>");
			out.flush();
			out.close();
			return null;
		}
		//判断是否重复
		List<SensorBean> list = new SensorDao().getAllList("Sensor_Name='"+Sensor_Name+"' and Sensor_StorehouseID='"+Sensor_StorehouseID+"' and Sensor_ID!='"+Sensor_ID+"'", "");
		if(list.size()>0){
			out.print("<script language='javascript'>alert('传感器已存在');history.back(-1)</script>");
			out.flush();
			out.close();
			return null;
		}
		else if(session.getAttribute("type").equals("1")){
		SensorBean bean = new SensorBean();
		bean.setSensor_ID(Integer.parseInt(Sensor_ID));
		bean.setSensor_StorehouseID(Integer.parseInt(Sensor_StorehouseID));
		bean.setSensor_Name(Sensor_Name);
		bean.setSensor_Type(Sensor_Type);
		bean.setSensor_Unit(Sensor_Unit);
		bean.setSensor_Description(Sensor_Description);
		new SensorDao().Update(bean);
		//跳转
		out.print("<script language='javascript'>alert('恭喜你，修改成功');window.location='SensorManager.action'</script>");
		out.flush();
		out.close();
		}
		else if(session.getAttribute("type").equals("2")){
			SensorBean bean = new SensorBean();
			bean.setSensor_ID(Integer.parseInt(Sensor_ID));
			bean.setSensor_StorehouseID(Integer.parseInt(Sensor_StorehouseID));
			bean.setSensor_Name(Sensor_Name);
			bean.setSensor_Type(Sensor_Type);
			bean.setSensor_Unit(Sensor_Unit);
			bean.setSensor_Description(Sensor_Description);
			
			new SensorDao().Update(bean);
			//跳转
			out.print("<script language='javascript'>alert('恭喜你，修改成功');window.location='SensorManager.action'</script>");
			out.flush();
			out.close();	
		}
		return null;
		
	}

}
