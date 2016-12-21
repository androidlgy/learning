package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.StorehouseBean;
import cn.wistron.dao.StorehouseDao;

import com.opensymphony.xwork2.ActionSupport;

public class MyStorehouseUpdateSave extends ActionSupport {
	private String Storehouse_ID;
	private String Storehouse_BuildingID;
	private String Storehouse_Name;
	private String Storehouse_Type;
	private String Storehouse_Number;
	private String Storehouse_Tel;
	public String getStorehouse_ID() {
		return Storehouse_ID;
	}
	public void setStorehouse_ID(String storehouse_ID) {
		Storehouse_ID = storehouse_ID;
	}
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
	HttpServletResponse response =null; 
	response=ServletActionContext.getResponse();
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	HttpSession session = ServletActionContext.getRequest().getSession();
	if(session.getAttribute("id")==null){
		out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
		out.flush();out.close();return null;
	}
	List<StorehouseBean> list = new StorehouseDao().getList("Storehouse_Name='"+Storehouse_Name+"' and Storehouse_BuildingID="+Storehouse_BuildingID+" and Storehouse_ID!='"+Storehouse_ID+"'", "");
	if(list.size()>0){
		out.print("<script language='javascript'>alert('该库房已存在！');history.back(-1);</script>");
		out.flush();out.close();return null;
	}
	StorehouseBean storehouseBean = new StorehouseBean();
	storehouseBean.setStorehouse_ID(Integer.parseInt(Storehouse_ID));
	storehouseBean.setStorehouse_BuildingID(Integer.parseInt(Storehouse_BuildingID));
	storehouseBean.setStorehouse_Name(Storehouse_Name);
	storehouseBean.setStorehouse_Type(Storehouse_Type);
	storehouseBean.setStorehouse_Number(Storehouse_Number);
	storehouseBean.setStorehouse_Tel(Storehouse_Tel);
	new StorehouseDao().update(storehouseBean);
	out.print("<script language='javascript'>alert('修改成功！');window.location='StorehouseManager.action';</script>");
	out.flush();
	out.close();
	return null;
	
}
	
	

}
