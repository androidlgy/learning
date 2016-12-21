package cn.wistron.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Quit extends ActionSupport {
	public String execute() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("id");
		session.removeAttribute("type");
		session.removeAttribute("Manager_Username");
		return SUCCESS;
		
	}

}
