package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import cn.wistron.bean.UserBean;
import cn.wistron.dao.UserBeanDao;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class RoomAdminUpdateSave extends ActionSupport {
	//用于封装用户请求的数据
	private String User_ID;
	private String User_Username;
	private String User_Password;
	private String User_Name;
	private String User_Sex;
	private String User_Tel;
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
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
	//execute方法
	public String execute() throws Exception{
		HttpServletResponse response = null;
		response= ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获得输出
		PrintWriter out = response.getWriter();
		//得到session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('验证不合格，请重新登陆！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		List<UserBean> list = new UserBeanDao().GetList("User_Username='"+User_Username+"' and User_ID !='"+User_ID+"'", "");
		if((list.size())>0){
			out.print("<script language='javascript'>alert('此用户已经存在！');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		UserBean userbean = new UserBean();
		userbean.setUser_ID(Integer.parseInt(User_ID));
		userbean.setUser_Username(User_Username);
		userbean.setUser_Password(User_Password);
		userbean.setUser_Name(User_Name);
		userbean.setUser_Sex(User_Sex);
		userbean.setUser_Tel(User_Tel);
	    new UserBeanDao().Update(userbean);
	    out.print("<script language='javascript'>alert('恭喜，修改成功！');window.location='RoomAdminManager.action';</script>");
		return null;
	}
	
	

}
