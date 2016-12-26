package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.dao.ManagerDao;
import cn.wistron.dao.UserBeanDao;

public class MuseumAdminDel extends ActionSupport {
	private String Manager_ID;

	public String getManager_ID() {
		return Manager_ID;
	}
	public void setManager_ID(String manager_ID) {
		Manager_ID = manager_ID;
	}
	//�����û������execute����
	public String execute() throws Exception{
		//������룬ҳ�����
		HttpServletResponse response=null;
        response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        //����session����
        HttpSession session = ServletActionContext.getRequest().getSession();
		
        //�ж��Ƿ�������½
        if(session.getAttribute("id")==null){
        	out.print("<script language='javascript'>alert('�����µ�½��');window.location='Login.jsp'; </script>");
        	out.flush();
        	out.close();
        	return null;
        }
        //ɾ��
        new ManagerDao().delete(Integer.parseInt(Manager_ID));
        return SUCCESS;
		
	}
	

}
