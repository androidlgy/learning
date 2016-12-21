package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.MuseumBean;
import cn.wistron.bean.StorehouseBean;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.MuseumDao;
import cn.wistron.dao.StorehouseDao;

import com.opensymphony.xwork2.ActionSupport;

public class MyStorehouseManager extends ActionSupport {
	private List<StorehouseBean> storehousebeanlist ;
	private List<BuildingBean> buildingbeanlist;
	private String Storehouse_BuildingID;
	private String SearchRow;
	private String SearchKey;
	private String Building_MuseumID;
	
	public List<StorehouseBean> getStorehousebeanlist() {
		return storehousebeanlist;
	}
	public void setStorehousebeanlist(List<StorehouseBean> storehousebeanlist) {
		this.storehousebeanlist = storehousebeanlist;
	}
	public List<BuildingBean> getBuildingbeanlist() {
		return buildingbeanlist;
	}
	public void setBuildingbeanlist(List<BuildingBean> buildingbeanlist) {
		this.buildingbeanlist = buildingbeanlist;
	}
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	public String getStorehouse_BuildingID() {
		return Storehouse_BuildingID;
	}
	public void setStorehouse_BuildingID(String storehouse_BuildingID) {
		Storehouse_BuildingID = storehouse_BuildingID;
	}
	
	public String getBuilding_MuseumID() {
		return Building_MuseumID;
	}
	public void setBuilding_MuseumID(String building_MuseumID) {
		Building_MuseumID = building_MuseumID;
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
		buildingbeanlist = new BuildingDao().getList("Building_MuseumID="+session.getAttribute("id"), "Building_Name");
		storehousebeanlist=new StorehouseDao().getList(strwhere+" and Museum_ID='"+session.getAttribute("id")+"'", "Storehouse_Name");
		return SUCCESS;
	}
	
public boolean isInValid(String str){
	return (str==null||str.length()==0);
}	

}
