package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.wistron.dao.*;

public class MuseumDel extends ActionSupport {
	private String Museum_ID;

	
	public String getMuseum_ID() {
		return Museum_ID;
	}


	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}


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
		        int count = new MuseumDao().getTotalBuildingCount("Museum_ID='"+Museum_ID+"'");
		        if(count==0){
		        //ɾ��
		        new MuseumDao().delete(Integer.parseInt(Museum_ID));
		        //��ת
		        out.print("<script language='javascript'>alert('ɾ�������ݳɹ���');window.location='MuseumManager.action'; </script>");
		        out.flush();
		        out.close();
		        return null;
		        }
		        else{
		        	//��ת
			        out.print("<script language='javascript'>alert('�õ������´���¥�ȷ��ɾ����');window.location='MuseumManager.action'; </script>");
			        out.flush();
			        out.close();	
			        return null;
		        }
		        
	}
	

}
