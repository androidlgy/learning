package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.bean.BuildingBean;
import cn.wistron.dao.*;

public class MyBuildingUpdateSave extends ActionSupport {
	private String Building_ID;
	private String Building_Name;
	private String Building_Introduction;
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String building_ID) {
		Building_ID = building_ID;
	}
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String building_Name) {
		Building_Name = building_Name;
	}
	public String getBuilding_Introduction() {
		return Building_Introduction;
	}
	public void setBuilding_Introduction(String building_Introduction) {
		Building_Introduction = building_Introduction;
	}
	public String execute() throws Exception{
		HttpServletResponse response = null;
		response=ServletActionContext.getResponse();
		//解决乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取输出
		PrintWriter out = response.getWriter();
		//得到session
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('信息验证失败，请重新登陆!');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		List<BuildingBean> list = new BuildingDao().getList("Building_Name='"+Building_Name+"' and Building_ID!="+Building_ID,"");
		if(list.size()>0){
			out.print("<script language='javascript'>alert('用户名已存在!');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		//修改
		BuildingBean bean =new BuildingBean();
		bean = new BuildingDao().getBean(Integer.parseInt(Building_ID));
		bean.setBuilding_Name(Building_Name);
		bean.setBuilding_Introduction(Building_Introduction);		
		new BuildingDao().update(bean);
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='MyBuildingManager.action';</script>");
		out.flush();
		out.close();
		return null;
		
	}
	

}
