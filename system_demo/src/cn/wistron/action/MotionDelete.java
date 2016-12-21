package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.dao.MotionDao;

import com.opensymphony.xwork2.ActionSupport;

public class MotionDelete extends ActionSupport {
	private String Motion_ID;

	public String getMotion_ID() {
		return Motion_ID;
	}

	public void setMotion_ID(String motion_ID) {
		Motion_ID = motion_ID;
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
        //删除
        new MotionDao().delete(Integer.parseInt(Motion_ID));
        out.print("<script language='javascript'>alert('删除成功！');window.location='MotionManager.action'; </script>");
    	out.flush();
    	out.close();
		return SUCCESS;
	}

}
