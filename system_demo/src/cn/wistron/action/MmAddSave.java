package cn.wistron.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MmBean;
import cn.wistron.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class MmAddSave extends ActionSupport {
	//封装请求数据
	private String MM_MuseumId;
	private String MM_ManagerId;
	
	public String getMM_MuseumId() {
		return MM_MuseumId;
	}

	public void setMM_MuseumId(String mM_MuseumId) {
		MM_MuseumId = mM_MuseumId;
	}

	public String getMM_ManagerId() {
		return MM_ManagerId;
	}

	public void setMM_ManagerId(String mM_ManagerId) {
		MM_ManagerId = mM_ManagerId;
	}

	//执行execute方法
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response = ServletActionContext.getResponse();
		//设置编码
	    response.setContentType("text/html;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    //获取输出
	    PrintWriter out = response.getWriter();
	    //获取session
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    //判断登陆状态
	    if(session.getAttribute("id")==null){
	    	out.print("<script language='javascript'>alert('验证失败，请重新登陆！');window.location='Login.jsp';</script>");
	    	out.flush();
	    	out.close();
	    	return null;
	    }
	    //验证是否存在
	   List<MmBean> list = new MmDao().getList("MM_MuseumId='"+MM_MuseumId+"' and MM_ManagerId='"+MM_ManagerId+"'", "");
	   if(list.size()>0){
		   out.print("<script language='javascript'>alert('该管理员已经在管理本博物馆了，不要重复添加！');history.back(-1);</script>");
	       out.flush();
	       out.close();
	       return null;
	   }
	   //添加
	   MmBean bean = new MmBean();
	   bean.setMM_ManagerId(Integer.parseInt(MM_ManagerId));
	   bean.setMM_MuseumId(Integer.parseInt(MM_MuseumId));
	   new MmDao().add(bean);
	   //添加成功，跳转
	   out.print("<script language='javascript'>alert('添加成功');window.location='MmManager.action?Museum_ID="+MM_MuseumId+"';</script>");
	   out.flush();out.close();
	   return null;
	}
	

}
