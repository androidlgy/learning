package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.bean.MuseumBean;
import cn.wistron.dao.*;

public class MuseumUpdateSave extends ActionSupport {
	private String Museum_ID;
	private String Museum_Name;
	private String Museum_Address;
	private String Museum_PhoneNumber;
	private String Museum_Email;
	private String Museum_Description;
	
	public String getMuseum_ID() {
		return Museum_ID;
	}

	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}

	public String getMuseum_Name() {
		return Museum_Name;
	}

	public void setMuseum_Name(String museum_Name) {
		Museum_Name = museum_Name;
	}

	public String getMuseum_Address() {
		return Museum_Address;
	}

	public void setMuseum_Address(String museum_Address) {
		Museum_Address = museum_Address;
	}

	public String getMuseum_PhoneNumber() {
		return Museum_PhoneNumber;
	}

	public void setMuseum_PhoneNumber(String museum_PhoneNumber) {
		Museum_PhoneNumber = museum_PhoneNumber;
	}

	public String getMuseum_Email() {
		return Museum_Email;
	}

	public void setMuseum_Email(String museum_Email) {
		Museum_Email = museum_Email;
	}

	public String getMuseum_Description() {
		return Museum_Description;
	}

	public void setMuseum_Description(String museum_Description) {
		Museum_Description = museum_Description;
	}

	public String execute() throws Exception{
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		//解决乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取输出
		PrintWriter out = response.getWriter();
		//得到session
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('信息验证失败，请重新登陆!');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		List<MuseumBean> list = new MuseumDao().getList("Museum_Name='"+Museum_Name+"' and Museum_ID!='"+Museum_ID+"'", "");
		if(list.size()>0){
			out.print("<script language='javascript'>alert('用户名已存在!');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		//修改
		MuseumBean bean =new MuseumBean(Integer.parseInt(Museum_ID), Museum_Name, Museum_Description, Museum_Address, Museum_PhoneNumber, Museum_Email);		
		new MuseumDao().update(bean);
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='MuseumManager.action';</script>");
		out.flush();
		out.close();
		return null;
		
	}
	

}
