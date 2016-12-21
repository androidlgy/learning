package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.UBBean;
import cn.wistron.bean.UserBean;
import cn.wistron.dao.*;

import com.opensymphony.xwork2.ActionSupport;

public class UBManager extends ActionSupport {
	//封装请求的数据
	private String Building_ID;
	private List<UserBean> userList;
	private List<UBBean> list;
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String building_ID) {
		Building_ID = building_ID;
	}
	public List<UserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
	public List<UBBean> getList() {
		return list;
	}
	public void setList(List<UBBean> list) {
		this.list = list;
	}
	//执行execute方法
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
	    //查询
	    userList = new UserBeanDao().GetList("", "");
	    //查询
	    list = new UBDao().getList("UB_BuildingID='"+Building_ID+"'","");
		return SUCCESS;
	}
	
	

}
