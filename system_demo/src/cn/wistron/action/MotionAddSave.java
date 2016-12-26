package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MotionBean;
import cn.wistron.dao.MotionDao;

import com.opensymphony.xwork2.ActionSupport;

public class MotionAddSave extends ActionSupport {
	private String Motion_Name;
	private String Motion_Type;
	private String Motion_Msg;
	
	public String getMotion_Name() {
		return Motion_Name;
	}
	public void setMotion_Name(String motion_Name) {
		Motion_Name = motion_Name;
	}
	public String getMotion_Type() {
		return Motion_Type;
	}
	public void setMotion_Type(String motion_Type) {
		Motion_Type = motion_Type;
	}
	public String getMotion_Msg() {
		return Motion_Msg;
	}
	public void setMotion_Msg(String motion_Msg) {
		Motion_Msg = motion_Msg;
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
  List<MotionBean> list = new MotionDao().getList("Motion_Name='"+Motion_Name+"' and Motion_Type='"+Motion_Type+"'","");
    if(list.size()>0)
    {
    	out.print("<script language='javascript'>alert('�����Ѵ��ڣ�');history.back(-1);</script>");
    	out.flush();
    	out.close();
    	return null;
    }
    MotionBean bean = new MotionBean();
    bean.setMotion_Name(Motion_Name);
    bean.setMotion_Type(Motion_Type);
    bean.setMotion_Msg(Motion_Msg);
    new MotionDao().add(bean);
    out.print("<script language='javascript'>alert('��ӳɹ���');window.location='MotionManager.action';</script>");
    out.flush();
    out.close();
    return null;
    }
}
