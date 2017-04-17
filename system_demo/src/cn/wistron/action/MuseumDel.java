package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.wistron.dao.*;

public class MuseumDel extends ActionSupport {
	private String Museum_ID;

	
	public String getMuseum_ID() {
		return Museum_ID;
	}


	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
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
		        int count = new MuseumDao().getTotalBuildingCount("Museum_ID='"+Museum_ID+"'");
		        if(count==0){
		        //删除
		        new MuseumDao().delete(Integer.parseInt(Museum_ID));
		        //跳转
		        out.print("<script language='javascript'>alert('删除档案馆成功！');window.location='MuseumManager.action'; </script>");
		        out.flush();
		        out.close();
		        return null;
		        }
		        else{
		        	//跳转
			        out.print("<script language='javascript'>alert('该档案馆下存在楼宇，确定删除？');window.location='MuseumManager.action'; </script>");
			        out.flush();
			        out.close();	
			        return null;
		        }
		        
	}
	

}
