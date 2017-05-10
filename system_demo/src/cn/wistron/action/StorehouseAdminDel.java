package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.TreasuryDao;

import com.opensymphony.xwork2.ActionSupport;

public class StorehouseAdminDel extends ActionSupport {
	private String Treasury_ID;
	
	public String getTreasury_ID() {
		return Treasury_ID;
	}

	public void setTreasury_ID(String treasury_ID) {
		Treasury_ID = treasury_ID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
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
		        new TreasuryDao().delete(Integer.parseInt(Treasury_ID));
		        return SUCCESS;
	}

}
