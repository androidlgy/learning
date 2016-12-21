package cn.wistron.action;

import java.io.PrintWriter;
import cn.wistron.dao.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UBDel extends ActionSupport {
	private String UB_ID;
	private String Building_ID;
	public String getUB_ID() {
		return UB_ID;
	}
	public void setUB_ID(String uB_ID) {
		UB_ID = uB_ID;
	}
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String building_ID) {
		Building_ID = building_ID;
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
		//删除
				new UBDao().delete(Integer.parseInt(UB_ID));
				out.print("<script language='javascript'>window.location='UBManager.action?Building_ID="+Building_ID+"';</script>");
				out.flush();
				out.close();
				return SUCCESS;
		
	}
	
	

}
