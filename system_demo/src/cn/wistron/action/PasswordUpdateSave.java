package cn.wistron.action;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wistron.bean.AdminBean;
import cn.wistron.bean.ManagerBean;
import cn.wistron.bean.UserBean;
import cn.wistron.dao.*;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordUpdateSave extends ActionSupport {
	private String Password;
	private String Password2;
	private String Msg;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPassword2() {
		return Password2;
	}
	public void setPassword2(String password2) {
		Password2 = password2;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	//执行execute方法
	public String execute() throws Exception{
		
        HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//得到输出
		java.io.PrintWriter out = response.getWriter();
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		String type = session.getAttribute("type").toString();
		if(type.equals("1"))//最高管理员身份
		{
			//验证密码
			if(new AdminDao().CheckPassword(session.getAttribute("id").toString(), Password)){
				AdminBean adminBean = new AdminBean();
				adminBean=new AdminDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				//修改密码
				adminBean.setAdmin_Password(Password2);
				new AdminDao().Update(adminBean);
				out.print("<script language='javascript'>alert('修改密码成功');window.location='index.jsp'</script>");
				out.flush();
				out.close();
				return null;
			}else{
				Msg="用户名或者密码有误";
				return INPUT;
			}
			
		}
		else if(type.equals("2"))
		{
			//普通库房管理员
			if(new ManagerDao().CheckPassword(session.getAttribute("id").toString(), Password)){
				ManagerBean managerbean=new ManagerBean();
				managerbean = new ManagerDao().getBean(Integer.parseInt(session.getAttribute("id").toString()));
				managerbean.setManager_Password(Password2);
				new ManagerDao().update(managerbean);	
				out.print("<script language='javascript'>alert('修改密码成功');window.location='index.jsp'</script>");
				out.flush();
				out.close();
				return null;
	         }else{
	        	Msg="用户名或者密码有误";
	        	return INPUT;
	         }
		
	    }
		else
		{
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}

	}
}
