package cn.wistron.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.AdminDao;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.ManagerDao;
import cn.wistron.dao.SensorDao;
import cn.wistron.dao.UserBeanDao;

import com.opensymphony.xwork2.ActionSupport;

public class GoLogin extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private String Type;
    private String Username;
    private String Password;
    private String Msg;
    private List<SensorBean> list;
	private String SearchKey;
	private String SearchRow;
	private String Storehouse_BuildingID;
	private List<BuildingBean> blist;
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
	
	public List<BuildingBean> getBlist() {
		return blist;
	}
	public void setBlist(List<BuildingBean> blist) {
		this.blist = blist;
	}

	public List<SensorBean> getList() {
		return list;
	}
	public void setList(List<SensorBean> list) {
		this.list = list;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getStorehouse_BuildingID() {
		return Storehouse_BuildingID;
	}
	public void setStorehouse_BuildingID(String storehouse_BuildingID) {
		Storehouse_BuildingID = storehouse_BuildingID;
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
				 String strwhere="1=1";
				    if(!(isInvalid(SearchKey))){
				    	strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
				    }
				    if(!isInvalid(Storehouse_BuildingID)){
				    	strwhere+=" and Storehouse_BuildingID="+Storehouse_BuildingID;
				    }
				    blist = new BuildingDao().getList("", "Building_Name");
					list=new SensorDao().getList(strwhere, "Sensor_Name");
					
				return SUCCESS;
			}
			
		}
		else if(Type.equals("档案馆管理员"))
		{
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
	public boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
	}
    
    


