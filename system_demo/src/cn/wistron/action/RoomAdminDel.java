package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.wistron.dao.UserBeanDao;

public class RoomAdminDel extends ActionSupport {
	private String User_ID;

	public String getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
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
        new UserBeanDao().delete(Integer.parseInt(User_ID));
        return SUCCESS;
		
	}
	

}
