package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.SensorDao;

import com.opensymphony.xwork2.ActionSupport;

public class SensorDelete extends ActionSupport {
	private String Sensor_ID;

	public String getSensor_ID() {
		return Sensor_ID;
	}

	public void setSensor_ID(String sensor_ID) {
		Sensor_ID = sensor_ID;
	}
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("type")==null){
			out.print("<script language='javascript'>alter('登陆验证失败,请重新登陆');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		else if(session.getAttribute("type").equals("1")){
		new SensorDao().Delete("Sensor_ID="+Integer.parseInt(Sensor_ID));
		out.print("<script language='javascript'>alter('删除成功');window.location='SensorManager.action';</script>");
		}
		else if(session.getAttribute("type").equals("2")){
			new SensorDao().Delete("Sensor_ID="+Integer.parseInt(Sensor_ID));
			out.print("<script language='javascript'>alter('删除成功');window.location='SensorManager.action';</script>");
		}
		return SUCCESS;
		
	}

}
