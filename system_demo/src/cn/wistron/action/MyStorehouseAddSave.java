package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.StorehouseBean;
import cn.wistron.dao.StorehouseDao;

import com.opensymphony.xwork2.ActionSupport;

public class MyStorehouseAddSave extends ActionSupport {
	private String Storehouse_BuildingID;
	private String Storehouse_Name;
	private String Storehouse_Type;
	private String Storehouse_Number;
	private String Storehouse_Tel;
	public String getStorehouse_BuildingID() {
		return Storehouse_BuildingID;
	}
	public void setStorehouse_BuildingID(String storehouse_BuildingID) {
		Storehouse_BuildingID = storehouse_BuildingID;
	}
	public String getStorehouse_Name() {
		return Storehouse_Name;
	}
	public void setStorehouse_Name(String storehouse_Name) {
		Storehouse_Name = storehouse_Name;
	}
	public String getStorehouse_Type() {
		return Storehouse_Type;
	}
	public void setStorehouse_Type(String storehouse_Type) {
		Storehouse_Type = storehouse_Type;
	}
	public String getStorehouse_Number() {
		return Storehouse_Number;
	}
	public void setStorehouse_Number(String storehouse_Number) {
		Storehouse_Number = storehouse_Number;
	}
	public String getStorehouse_Tel() {
		return Storehouse_Tel;
	}
	public void setStorehouse_Tel(String storehouse_Tel) {
		Storehouse_Tel = storehouse_Tel;
	}
	public String execute() throws Exception{
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		List<StorehouseBean> list = new StorehouseDao().getList("Storehouse_Name='"+Storehouse_Name+"' and Storehouse_BuildingID='"+Storehouse_BuildingID+"' and Museum_ID='"+session.getAttribute("id")+"'", "");
		if(list.size()>0){
			out.print("<script language='javascript'>alert('���û��Ѵ��ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}	
		StorehouseBean bean = new StorehouseBean();
		bean.setStorehouse_BuildingID(Integer.parseInt(Storehouse_BuildingID));
		bean.setStorehouse_Name(Storehouse_Name);
		bean.setStorehouse_Type(Storehouse_Type);
		bean.setStorehouse_Number(Storehouse_Number);
		bean.setStorehouse_Tel(Storehouse_Tel);
		new StorehouseDao().add(bean);
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='MyStorehouseManager.action';</script>");
		out.flush();out.close();return null;
	}

}
