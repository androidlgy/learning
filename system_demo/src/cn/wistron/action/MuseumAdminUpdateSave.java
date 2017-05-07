package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import cn.wistron.bean.ManagerBean;
import cn.wistron.dao.ManagerDao;
import com.opensymphony.xwork2.ActionSupport;

public class MuseumAdminUpdateSave extends ActionSupport {
    private String Manager_ID;
    private String Manager_Username;
    private String Manager_Password;
    private String Manager_Name;
    private String Manager_Sex;
    private String Manager_Tel;
	public String getManager_ID() {
		return Manager_ID;
	}
	public void setManager_ID(String manager_ID) {
		Manager_ID = manager_ID;
	}
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
	//execute方法
		public String execute() throws Exception{
			HttpServletResponse response = null;
			response= ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//获得输出
			PrintWriter out = response.getWriter();
			//得到session对象
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('验证不合格，请重新登陆！');window.location='Login.jsp';</script>");
				out.flush();
				out.close();
				return null;
			}
			List<ManagerBean> list = new ManagerDao().getList("Manager_Username='"+Manager_Username+"' and Manager_ID !='"+Manager_ID+"'", "");
			if((list.size())>0){
				out.print("<script language='javascript'>alert('抱歉，此档案馆管理员已经存在！');history.back(-1);</script>");
				out.flush();
				out.close();
				return null;
			}
			ManagerBean bean = new ManagerBean(Integer.parseInt(Manager_ID), Manager_Username, Manager_Password, Manager_Name, Manager_Sex, Manager_Tel);
		    new ManagerDao().update(bean);
		    out.print("<script language='javascript'>alert('恭喜，修改档案馆管理员信息成功！');window.location='MuseumAdminManager.action';</script>");
			return null;
		}
}
