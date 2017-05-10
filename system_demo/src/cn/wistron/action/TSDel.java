package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.TSDao;

import com.opensymphony.xwork2.ActionSupport;

public class TSDel extends ActionSupport {
	private String TS_ID;
	private String TS_StorehouseID;
	public String getTS_ID() {
		return TS_ID;
	}
	public void setTS_ID(String tS_ID) {
		TS_ID = tS_ID;
	}
	public String getTS_StorehouseID() {
		return TS_StorehouseID;
	}
	public void setTS_StorehouseID(String tS_StorehouseID) {
		TS_StorehouseID = tS_StorehouseID;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
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
		new TSDao().delete(Integer.parseInt(TS_ID));
		out.print("<script language='javascript'>window.location='TSManager.action?Storehouse_ID="+TS_StorehouseID+"';</script>");
		out.flush();
		out.close();
		return SUCCESS;
	}
	

}
