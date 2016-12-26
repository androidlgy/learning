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
	//��װ���������
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
	//ִ��execute����
	public String execute() throws Exception{
		HttpServletResponse response =null;
		//�����������
	    response=ServletActionContext.getResponse();
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    //��ȡ���
	    PrintWriter out = response.getWriter();
	    //��ȡsession
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    if(session.getAttribute("id")==null){
	    	out.print("<script language='javascript'>alert('��֤ʧ�ܣ������µ�½');window.location='Login.jsp';</script>");
	    	out.flush();
	    	out.close();
	    	return null;
	    }
	    //��ѯ
	    userList = new UserBeanDao().GetList("", "");
	    //��ѯ
	    list = new UBDao().getList("UB_BuildingID='"+Building_ID+"'","");
		return SUCCESS;
	}
	
	

}
