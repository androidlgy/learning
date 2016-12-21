package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class MyBuildingUpdate extends ActionSupport {
	private String Building_ID;
	private BuildingBean buildingbean;

	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String building_ID) {
		Building_ID = building_ID;
	}
	public BuildingBean getBuildingbean() {
		return buildingbean;
	}
	public void setBuildingbean(BuildingBean buildingbean) {
		this.buildingbean = buildingbean;
	}
	public String execute() throws Exception{
		HttpServletResponse response =null;
		//避免输出乱码
	    response=ServletActionContext.getResponse();
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    //获取输出
	    PrintWriter out = response.getWriter();
	    //获取session
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    if(session.getAttribute("id")==null){
	    	out.print("<script language='javascript'>alert('验证失败，请重新登陆');window.location='Login.jsp';</script>");
	    	out.flush();
	    	out.close();
	    	return null;
	    }
	  
	    buildingbean = new BuildingDao().getBean(Integer.parseInt(Building_ID));
	    return SUCCESS;
	   
	   
	  
	}
	

}
