package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.StorehouseBean;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.StorehouseDao;

import com.opensymphony.xwork2.ActionSupport;

public class SensorAdd extends ActionSupport {
	private List<BuildingBean> blist;
	private List<StorehouseBean> slist;
	public List<BuildingBean> getBlist() {
		return blist;
	}
	public void setBlist(List<BuildingBean> blist) {
		this.blist = blist;
	}
	public List<StorehouseBean> getSlist() {
		return slist;
	}
	public void setSlist(List<StorehouseBean> slist) {
		this.slist = slist;
	}
	public String execute() throws Exception{
		HttpServletResponse response =null;
        response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute("id")==null){
        	out.print("<script language='javascript'>alert('ÇëÖØÐÂµÇÂ¼£¡');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;	
        }
        blist= new BuildingDao().getList("","Building_Name");
        slist=new StorehouseDao().getList("","Storehouse_Name");
        return SUCCESS;
        
		
	}

}
