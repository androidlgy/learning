package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import cn.wistron.dao.UserBeanDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;

import cn.wistron.bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;

public class RoomAdminAdd extends ActionSupport {
	private String User_Username;
	private String User_Password;
	private String User_Name;
	private String User_Sex;
	private String User_Tel;
	private UserBean userbean;
	public String getUser_Username() {
		return User_Username;
	}
	public void setUser_Username(String user_Username) {
		User_Username = user_Username;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Sex() {
		return User_Sex;
	}
	public void setUser_Sex(String user_Sex) {
		User_Sex = user_Sex;
	}
	public String getUser_Tel() {
		return User_Tel;
	}
	public void setUser_Tel(String user_Tel) {
		User_Tel = user_Tel;
	}
	public String execute() throws Exception{
	    HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		PrintWriter out = response.getWriter();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('验证不合格，请重新登陆');window.location='Login.jsp'</script>");
			out.flush();
			out.close();
			return null;
		}
	   //判断用户名是否已经重复
		List<UserBean> list = new UserBeanDao().GetList("User_Username='"+User_Username+"'","");
		if((list.size())>0){
		out.print("<script language='javascript'>alert('用户名已存在，请输入新的用户名');history.back(-1)</script>");
		out.flush();
		out.close();
		return null;
		}
		 userbean = new UserBean();
		 userbean.setUser_Username(User_Username);
		 userbean.setUser_Password(User_Password);
		 userbean.setUser_Name(User_Name);
		 userbean.setUser_Sex(User_Sex);
		 userbean.setUser_Tel(User_Tel);
		 new UserBeanDao().Add(userbean);
		 out.print("<script language='javascript'>alert('恭喜您，添加成功');window.location='RoomAdminManager.action'</script>");
			out.flush();
			out.close();
		return SUCCESS;	
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

}
