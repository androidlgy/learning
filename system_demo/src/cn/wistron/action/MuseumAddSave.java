package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import cn.wistron.bean.MuseumBean;
import cn.wistron.dao.MuseumDao;

import com.opensymphony.xwork2.ActionSupport;

public class MuseumAddSave extends ActionSupport {
	private String Museum_Name;
	private String Museum_Address;
	private String Museum_PhoneNumber;
	private String Museum_Email;
	private String Museum_Description;
	
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
	//解决乱码，页面输出
	HttpServletResponse response=null;
    response = ServletActionContext.getResponse();
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    
    //创建session对象
    HttpSession session = ServletActionContext.getRequest().getSession();
	
    //判断是否正常登陆
    if(session.getAttribute("id")==null){
    	out.print("<script language='javascript'>alert('请重新登陆！');window.location='Login.jsp'; </script>");
    	out.flush();
    	out.close();
    	return null;
    }
    //查重
    List<MuseumBean> list = new MuseumDao().getList("Museum_Name='"+Museum_Name+"'","");//修改过
    if(list.size()>0){
    	out.print("<script language='javascript'>alert('该名称的档案馆已存在！');history.back(-1);</script>");
    	out.flush();
    	out.close();
    	return null;
    }
    //添加
    MuseumBean bean = new MuseumBean(Museum_Name, Museum_Description, Museum_Address, Museum_PhoneNumber, Museum_Email);
    new MuseumDao().add(bean);
    out.print("<script language='javascript'>alert('添加档案馆成功！');window.location='MuseumManager.action';</script>");
    out.flush();
    out.close();
    return null;

  }
}