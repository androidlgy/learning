package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.bean.MuseumBean;
import cn.wistron.dao.MuseumDao;
public class BuildingAdd extends ActionSupport{
	private List<MuseumBean> list;

	public List<MuseumBean> getList() {
		return list;
	}

	public void setList(List<MuseumBean> list) {
		this.list = list;
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
        list = new MuseumDao().getList("", "");
        return SUCCESS;
        
		
	}

}
