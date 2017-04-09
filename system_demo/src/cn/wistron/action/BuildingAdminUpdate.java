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
		//�����û������execute����
		public String execute() throws Exception{
			//������룬ҳ�����
			HttpServletResponse response=null;
			response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			//����session����
			HttpSession session = ServletActionContext.getRequest().getSession();
			//��֤�Ƿ�������½
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('�����µ�½��');window.location='Login.jsp';</script>");
				out.flush();
				out.close();
				return null;
			}
			//��ѯ����
			userbean = new UserBeanDao().GetBean(Integer.parseInt(User_ID));
			System.out.println(userbean.getUser_ID());
	        return SUCCESS;
		}
		
		//�ж��Ƿ��ֵ
			private boolean isInvalid(String value) {
				return (value == null || value.length() == 0);
			}
			
			//����
			public static void main(String[] args) {
				System.out.println();
			}
	}
