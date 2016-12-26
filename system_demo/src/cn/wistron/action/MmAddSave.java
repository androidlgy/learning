package cn.wistron.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MmBean;
import cn.wistron.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class MmAddSave extends ActionSupport {
	//��װ��������
	private String MM_MuseumId;
	private String MM_ManagerId;
	
	public String getMM_MuseumId() {
		return MM_MuseumId;
	}

	public void setMM_MuseumId(String mM_MuseumId) {
		MM_MuseumId = mM_MuseumId;
	}

	public String getMM_ManagerId() {
		return MM_ManagerId;
	}

	public void setMM_ManagerId(String mM_ManagerId) {
		MM_ManagerId = mM_ManagerId;
	}

	//ִ��execute����
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response = ServletActionContext.getResponse();
		//���ñ���
	    response.setContentType("text/html;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    //��ȡ���
	    PrintWriter out = response.getWriter();
	    //��ȡsession
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    //�жϵ�½״̬
	    if(session.getAttribute("id")==null){
	    	out.print("<script language='javascript'>alert('��֤ʧ�ܣ������µ�½��');window.location='Login.jsp';</script>");
	    	out.flush();
	    	out.close();
	    	return null;
	    }
	    //��֤�Ƿ����
	   List<MmBean> list = new MmDao().getList("MM_MuseumId='"+MM_MuseumId+"' and MM_ManagerId='"+MM_ManagerId+"'", "");
	   if(list.size()>0){
		   out.print("<script language='javascript'>alert('�ù���Ա�Ѿ��ڹ���������ˣ���Ҫ�ظ���ӣ�');history.back(-1);</script>");
	       out.flush();
	       out.close();
	       return null;
	   }
	   //���
	   MmBean bean = new MmBean();
	   bean.setMM_ManagerId(Integer.parseInt(MM_ManagerId));
	   bean.setMM_MuseumId(Integer.parseInt(MM_MuseumId));
	   new MmDao().add(bean);
	   //��ӳɹ�����ת
	   out.print("<script language='javascript'>alert('��ӳɹ�');window.location='MmManager.action?Museum_ID="+MM_MuseumId+"';</script>");
	   out.flush();out.close();
	   return null;
	}
	

}
