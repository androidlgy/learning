package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.SMDao;

import com.opensymphony.xwork2.ActionSupport;

public class MySMDel extends ActionSupport {
	private String SM_ID;
	private String Sensor_ID;
	public String getSM_ID() {
		return SM_ID;
	}
	public void setSM_ID(String sM_ID) {
		SM_ID = sM_ID;
	}
	public String getSensor_ID() {
		return Sensor_ID;
	}
	public void setSensor_ID(String sensor_ID) {
		Sensor_ID = sensor_ID;
	}
	public String execute() throws Exception{
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		//设置输出格式
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//获得输出
		PrintWriter out = response.getWriter();
		//得到session
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('验证失败，请重新登陆');window.location='Login.jsp';</script>");
	    	out.flush();
	    	out.close();
	    	return null;
		}
		new SMDao().delete(Integer.parseInt(SM_ID));
		out.print("<script language='javascript'>alert('删除成功');window.location='MySMManager.action?Sensor_ID="+Sensor_ID+"';</script>");
		return SUCCESS;
	}

}
