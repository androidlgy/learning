package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.SensorBean;
import cn.wistron.dao.SensorDao;

import com.opensymphony.xwork2.ActionSupport;

public class SensorAddSave extends ActionSupport {
	private String Sensor_StorehouseID;
	private String Sensor_Name;
	private String Sensor_Type;
	private String Sensor_Unit;
	private String Sensor_Description;
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
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		List<SensorBean> list = new SensorDao().getAllList("Sensor_StorehouseID='"+Sensor_StorehouseID+"' and Sensor_Name='"+Sensor_Name+"'", "");
		if(list.size()>0){
			out.print("<script language='javascript'>alert('此用户已存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		SensorBean sensorBean = new SensorBean();
		sensorBean.setSensor_StorehouseID(Integer.parseInt(Sensor_StorehouseID));
		sensorBean.setSensor_Name(Sensor_Name);
		sensorBean.setSensor_Type(Sensor_Type);
		sensorBean.setSensor_Unit(Sensor_Unit);
		sensorBean.setSensor_Description(Sensor_Description);
		new SensorDao().Add(sensorBean);
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='SensorManager.action';</script>");
		out.flush();out.close();return null;
	}

}
