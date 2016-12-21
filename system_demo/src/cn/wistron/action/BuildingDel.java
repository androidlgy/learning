package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.bean.StorehouseBean;
import cn.wistron.dao.*;

public class BuildingDel extends ActionSupport {
	private String Building_ID;

	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String building_ID) {
		Building_ID = building_ID;
	}
	public String execute() throws Exception{
		//解决乱码，页面输出
				HttpServletResponse response=null;
		        response = ServletActionContext.getResponse();
		        response.setCharacterEncoding("utf-8");
		        response.setContentType("text/html;charset=utf-8");
		        PrintWriter out = response.getWriter();
		        
		        //创建session对象
		        HttpSession session = ServletActionContext.getRequest().getSession();
				
		        //判断是否正常登陆
		        if(session.getAttribute("id")==null){
		        	out.print("<script language='javascript'>alert('请重新登陆！');window.location='Login.jsp'; </script>");
		        	out.flush();
		        	out.close();
		        	return null;
		        }
		        List<StorehouseBean> list = new StorehouseDao().getList("Storehouse_BuildingID="+Building_ID,"");
		        if(list.size()==0){
		        //删除
		        new BuildingDao().delete(Integer.parseInt(Building_ID));
		        //跳转
		        out.print("<script language='javascript'>alert('删除成功！');window.location='BuildingManager.action'; </script>");
		        out.flush();
		        out.close();
		        }
		        else{
		        	out.print("<script language='javascript'>alert('该楼宇下存在库房，请删除库房后，再删除！');window.location='BuildingManager.action'; </script>");
			        out.flush();
			        out.close();	
		        }
		        return null;
	}
	

}
