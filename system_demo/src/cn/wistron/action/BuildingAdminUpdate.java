package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.UserBean;
import cn.wistron.dao.UserBeanDao;

import com.opensymphony.xwork2.ActionSupport;

public class BuildingAdminUpdate extends ActionSupport{
	private String User_ID;
	private UserBean userbean;
	
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public UserBean getUserbean() {
		return userbean;
	}
	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
		//处理用户请求的execute方法
		public String execute() throws Exception{
			//解决乱码，页面输出
			HttpServletResponse response=null;
			response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			//创建session对象
			HttpSession session = ServletActionContext.getRequest().getSession();
			//验证是否正常登陆
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('请重新登陆！');window.location='Login.jsp';</script>");
				out.flush();
				out.close();
				return null;
			}
			//查询所有
			userbean = new UserBeanDao().GetBean(Integer.parseInt(User_ID));
			System.out.println(userbean.getUser_ID());
	        return SUCCESS;
		}
		
		//判断是否空值
			private boolean isInvalid(String value) {
				return (value == null || value.length() == 0);
			}
			
			//测试
			public static void main(String[] args) {
				System.out.println();
			}
	}
