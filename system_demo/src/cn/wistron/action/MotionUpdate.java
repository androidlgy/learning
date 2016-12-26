package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MotionBean;
import cn.wistron.dao.MotionDao;

import com.opensymphony.xwork2.ActionSupport;

public class MotionUpdate extends ActionSupport {
   private MotionBean motionbean;
   private String Motion_ID;
public MotionBean getMotionbean() {
	return motionbean;
}
public void setMotionbean(MotionBean motionbean) {
	this.motionbean = motionbean;
}
public String getMotion_ID() {
	return Motion_ID;
}
public void setMotion_ID(String motion_ID) {
	Motion_ID = motion_ID;
}
   public String execute() throws Exception{
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
	    	
	    motionbean = new MotionDao().getBean(Integer.parseInt(Motion_ID));
	   return SUCCESS;
   }
}
