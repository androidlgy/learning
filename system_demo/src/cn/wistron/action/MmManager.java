package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.ManagerBean;
import cn.wistron.bean.MmBean;
import cn.wistron.dao.*;

import com.opensymphony.xwork2.ActionSupport;

public class MmManager extends ActionSupport {
	//��װ���������
	private String Museum_ID;
	private List<ManagerBean> managerList;
	private List<MmBean> list;
	
	public String getMuseum_ID() {
		return Museum_ID;
	}

	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}


	public List<ManagerBean> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<ManagerBean> managerList) {
		this.managerList = managerList;
	}

	public List<MmBean> getList() {
		return list;
	}

	public void setList(List<MmBean> list) {
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
	    managerList = new ManagerDao().getList("", "");
	    //��ѯ
	    list = new MmDao().getList("MM_MuseumId='"+Museum_ID+"'","");
		return SUCCESS;
	}
	
	

}
