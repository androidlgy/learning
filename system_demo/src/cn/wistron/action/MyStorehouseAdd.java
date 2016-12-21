package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;

import cn.wistron.dao.BuildingDao;


import com.opensymphony.xwork2.ActionSupport;

public class MyStorehouseAdd extends ActionSupport {
	private List<BuildingBean> list;
	

	public List<BuildingBean> getList() {
		return list;
	}


	public void setList(List<BuildingBean> list) {
		this.list = list;
	}


	public String execute() throws Exception{
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('ÇëÖØÐÂµÇÂ¼£¡');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		list = new BuildingDao().getList("Building_MuseumID="+session.getAttribute("id"), "Building_Name");
		
		return SUCCESS;
	}

}
