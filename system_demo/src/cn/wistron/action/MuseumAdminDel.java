package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.dao.ManagerDao;
import cn.wistron.dao.UserBeanDao;

public class MuseumAdminDel extends ActionSupport {
	private String Manager_ID;

	public String getManager_ID() {
		return Manager_ID;
	}
	public void setManager_ID(String manager_ID) {
		Manager_ID = manager_ID;
	}
	//处理用户请求的execute方法
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
        //删除
        new ManagerDao().delete(Integer.parseInt(Manager_ID));
        return SUCCESS;
		
	}
	

}
