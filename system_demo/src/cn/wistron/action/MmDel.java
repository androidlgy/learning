package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.MmDao;

import com.opensymphony.xwork2.ActionSupport;

public class MmDel extends ActionSupport {
	private String MM_ID;
	private String Museum_ID;
	
	public String getMM_ID() {
		return MM_ID;
	}

	public void setMM_ID(String mM_ID) {
		MM_ID = mM_ID;
	}

	public String getMuseum_ID() {
		return Museum_ID;
	}

	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}

	@Override
	public String execute() throws Exception {
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
		        //删除
		        new MmDao().delete(Integer.parseInt(MM_ID));
		        return SUCCESS;
	}

}
