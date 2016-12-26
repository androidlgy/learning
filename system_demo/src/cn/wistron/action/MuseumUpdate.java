package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MuseumBean;
import cn.wistron.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class MuseumUpdate extends ActionSupport {
	private String Museum_ID;
	private MuseumBean Mesumbean;


	public String getMuseum_ID() {
		return Museum_ID;
	}


	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}


	public MuseumBean getMesumbean() {
		return Mesumbean;
	}


	public void setMesumbean(MuseumBean mesumbean) {
		Mesumbean = mesumbean;
	}


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
	    Mesumbean = new MuseumDao().getBean(Integer.parseInt(Museum_ID));
	    return SUCCESS;
	}
	

}
