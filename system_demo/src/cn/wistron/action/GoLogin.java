package cn.wistron.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.AdminDao;
import cn.wistron.dao.ManagerDao;
import cn.wistron.dao.UserBeanDao;

import com.opensymphony.xwork2.ActionSupport;

public class GoLogin extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private String Type;
    private String Username;
    private String Password;
    private String Msg;
    
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	//处理用户请求的excute方法
	public String execute() throws Exception{
		if(Type.equals("系统管理员")) 
		{
			if(null==new AdminDao().CheckLogin(Username, Password)){
				Msg="用户名或密码错误";
				return INPUT;
			}else{
				String Admin_ID=new AdminDao().CheckLogin(Username, Password);
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("id", Admin_ID);
				session.setAttribute("type", "1");
				session.setAttribute("Manager_Username",Username);
				return SUCCESS;
			}
			
		}
		else if(Type.equals("博物馆管理员")){
				if(null==new ManagerDao().CheckLogin(Username, Password)){
					Msg="用户名或密码错误";
					return INPUT;
				}
				else{
					String Manager_ID = new ManagerDao().CheckLogin(Username, Password);
					HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("id", Manager_ID);
					session.setAttribute("type", "2");
				    session.setAttribute("Manager_Username", Username);
					return SUCCESS;
				}
			}
		else{
			Msg="身份不匹配，请重新输入";
			return INPUT;
		}
		
		}
	}
    
    


