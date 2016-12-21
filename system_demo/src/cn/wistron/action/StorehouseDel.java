package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.StorehouseDao;

import com.opensymphony.xwork2.ActionSupport;

public class StorehouseDel extends ActionSupport {
	private String Storehouse_ID;

	public String getStorehouse_ID() {
		return Storehouse_ID;
	}

	public void setStorehouse_ID(String storehouse_ID) {
		Storehouse_ID = storehouse_ID;
	}
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		new StorehouseDao().delete(Integer.parseInt(Storehouse_ID));
		out.print("<script language='javascript'>alert('删除成功！');window.location='StorehouseManager.action'</script>");
	
		return SUCCESS;
	}

}
