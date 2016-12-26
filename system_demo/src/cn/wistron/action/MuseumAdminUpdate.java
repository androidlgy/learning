package cn.wistron.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.ManagerBean;
import cn.wistron.dao.ManagerDao;

import com.opensymphony.xwork2.ActionSupport;


public class MuseumAdminUpdate extends ActionSupport {
	private String Manager_ID;
	private ManagerBean bean;
	public String getManager_ID() {
		return Manager_ID;
	}
	public void setManager_ID(String manager_ID) {
		Manager_ID = manager_ID;
	}

	public ManagerBean getBean() {
		return bean;
	}
	public void setBean(ManagerBean bean) {
		this.bean = bean;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response =null;
		//�����������
	    response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
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
		    bean=new ManagerDao().getBean(Integer.parseInt(Manager_ID));
		    return SUCCESS;
	}

}
