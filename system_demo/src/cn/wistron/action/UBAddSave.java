package cn.wistron.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.UBBean;
import cn.wistron.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class UBAddSave extends ActionSupport {
	//��װ��������
	private String UB_UserID;
	private String UB_BuildingID;
	public String getUB_UserID() {
		return UB_UserID;
	}
	public void setUB_UserID(String uB_UserID) {
		UB_UserID = uB_UserID;
	}
	public String getUB_BuildingID() {
		return UB_BuildingID;
	}
	public void setUB_BuildingID(String uB_BuildingID) {
		UB_BuildingID = uB_BuildingID;
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
	   List<UBBean> list = new UBDao().getList("UB_UserID='"+UB_UserID+"' and UB_BuildingID='"+UB_BuildingID+"'", "");
	   if(list.size()>0){
		   out.print("<script language='javascript'>alert('�ù���Ա�Ѿ��ڹ���¥���ˣ���Ҫ�ظ���ӣ�');history.back(-1);</script>");
	       out.flush();
	       out.close();
	       return null;
	   }
	   //���
	   UBBean ubBean = new UBBean();
	   ubBean.setUB_UserID(Integer.parseInt(UB_UserID));
	   ubBean.setUB_BuildingID(Integer.parseInt(UB_BuildingID));
	   
	   new UBDao().add(ubBean);
	   //��ӳɹ�����ת
	   out.print("<script language='javascript'>alert('��ӳɹ�');window.location='UBManager.action?Building_ID="+UB_BuildingID+"';</script>");
	   out.flush();out.close();
	   return null;
	}
	

}
