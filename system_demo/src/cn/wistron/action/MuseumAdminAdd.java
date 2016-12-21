package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.ManagerBean;
import cn.wistron.dao.ManagerDao;

import com.opensymphony.xwork2.ActionSupport;

public class MuseumAdminAdd extends ActionSupport {
    private String Manager_Username;
    private String Manager_Password;
    private String Manager_Name;
    private String Manager_Sex;
    private String Manager_Tel;
	public String getManager_Username() {
		return Manager_Username;
	}
	public void setManager_Username(String manager_Username) {
		Manager_Username = manager_Username;
	}
	public String getManager_Password() {
		return Manager_Password;
	}
	public void setManager_Password(String manager_Password) {
		Manager_Password = manager_Password;
	}
	public String getManager_Name() {
		return Manager_Name;
	}
	public void setManager_Name(String manager_Name) {
		Manager_Name = manager_Name;
	}
	public String getManager_Sex() {
		return Manager_Sex;
	}
	public void setManager_Sex(String manager_Sex) {
		Manager_Sex = manager_Sex;
	}
	public String getManager_Tel() {
		return Manager_Tel;
	}
	public void setManager_Tel(String manager_Tel) {
		Manager_Tel = manager_Tel;
	}
    @Override
    public String execute() throws Exception {
    	// TODO Auto-generated method stub
    	  HttpServletResponse response =null;
  		response=ServletActionContext.getResponse();
  		response.setContentType("text/html;charset=utf-8");
  		response.setCharacterEncoding("utf-8");
  		HttpSession session = ServletActionContext.getRequest().getSession();
  		PrintWriter out = response.getWriter();
  		if(session.getAttribute("id")==null){
  			out.print("<script language='javascript'>alert('验证不合格，请重新登陆');window.location='Login.jsp'</script>");
  			out.flush();
  			out.close();
  			return null;
  		}
  		List<ManagerBean> list = new ManagerDao().getList("Manager_Username='"+Manager_Username+"'", "");
  		if(list.size()>0){
  			out.print("<script language='javascript'>alert('用户名已存在，请输入新的用户名');history.back(-1)</script>");
  			out.flush();
  			out.close();
  			return null;
  		}
  		ManagerBean bean = new ManagerBean(Manager_Username, Manager_Password, Manager_Name, Manager_Sex, Manager_Tel);
  		new ManagerDao().add(bean);
  		out.print("<script language='javascript'>alert('恭喜您，添加成功');window.location='MuseumAdminManager.action'</script>");
		out.flush();
		out.close();
    	return null;
    }
}
