package cn.wistron.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.SensorDao;

import com.opensymphony.xwork2.ActionSupport;


public class ParaManager extends ActionSupport {
	private List<SensorBean> list;
	private String SearchKey;
	private String SearchRow;
	private String Storehouse_BuildingID;
	private List<BuildingBean> blist;
	

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
	

	public List<BuildingBean> getBlist() {
		return blist;
	}

	public void setBlist(List<BuildingBean> blist) {
		this.blist = blist;
	}

	public String execute() throws Exception{
	
	HttpServletResponse response =null;
	//避免输出乱码
    response=ServletActionContext.getResponse();
    response.setContentType("text/html;charset=UTF-8");
	response.setCharacterEncoding("UTF-8");
    //获取输出
    PrintWriter out = response.getWriter();
    //获取session
    HttpSession session = ServletActionContext.getRequest().getSession();
    if(session.getAttribute("id")==null){
    	out.print("<script language='javascript'>alert('验证失败，请重新登陆');window.location='Login.jsp';</script>");
    	out.flush();
    	out.close();
    	return null;
    }
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
	public boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
}
