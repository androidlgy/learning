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
import cn.wistron.dao.StorehouseDao;

import com.opensymphony.xwork2.ActionSupport;

public class MySensorManager extends ActionSupport {
	private List<BuildingBean> blist;
	private List<SensorBean> slist;
	private String Storehouse_BuildingID;
	private String SearchKey;
	private String SearchRow;
	public List<BuildingBean> getBlist() {
		return blist;
	}
	public void setBlist(List<BuildingBean> blist) {
		this.blist = blist;
	}
	public List<SensorBean> getSlist() {
		return slist;
	}
	public void setSlist(List<SensorBean> slist) {
		this.slist = slist;
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
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('ÇëÖØÐÂµÇÂ¼£¡');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		String strwhere="1=1";
		if(!isInValid(SearchKey)){
			strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}
		if(!isInValid(Storehouse_BuildingID)){
			strwhere+=" and Storehouse_BuildingID="+Storehouse_BuildingID;
		}
		blist = new BuildingDao().getList("Building_MuseumID="+session.getAttribute("id"), "Building_Name");
		slist=new SensorDao().getList(strwhere+" and Manager_ID="+session.getAttribute("id"), "Sensor_Name");
		return SUCCESS;
	}
	
public boolean isInValid(String str){
	return (str==null||str.length()==0);
}	


}
