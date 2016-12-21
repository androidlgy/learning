package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.dao.BuildingDao;

import com.opensymphony.xwork2.ActionSupport;

public class MyBuildingManager extends ActionSupport {
	private List<BuildingBean> list;

	public List<BuildingBean> getList() {
		return list;
	}

	public void setList(List<BuildingBean> list) {
		this.list = list;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
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
	    list = new BuildingDao().getList("Museum_ID="+session.getAttribute("id"),"Building_Name");
		return SUCCESS;
	}
 
}
