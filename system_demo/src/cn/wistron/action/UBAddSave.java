package cn.wistron.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.UBBean;
import cn.wistron.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class UBAddSave extends ActionSupport {
	//封装请求数据
	private String UB_UserID;
	private String UB_BuildingID;
	public String getUB_UserID() {
		return UB_UserID;
	}
	public void setUB_UserID(String uB_UserID) {
		UB_UserID = uB_UserID;
	}
	public String getUB_BuildingID() {
		return UB_BuildingID;
	}
	public void setUB_BuildingID(String uB_BuildingID) {
		UB_BuildingID = uB_BuildingID;
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
	   List<UBBean> list = new UBDao().getList("UB_UserID='"+UB_UserID+"' and UB_BuildingID='"+UB_BuildingID+"'", "");
	   if(list.size()>0){
		   out.print("<script language='javascript'>alert('该管理员已经在管理本楼宇了，不要重复添加！');history.back(-1);</script>");
	       out.flush();
	       out.close();
	       return null;
	   }
	   //添加
	   UBBean ubBean = new UBBean();
	   ubBean.setUB_UserID(Integer.parseInt(UB_UserID));
	   ubBean.setUB_BuildingID(Integer.parseInt(UB_BuildingID));
	   
	   new UBDao().add(ubBean);
	   //添加成功，跳转
	   out.print("<script language='javascript'>alert('添加成功');window.location='UBManager.action?Building_ID="+UB_BuildingID+"';</script>");
	   out.flush();out.close();
	   return null;
	}
	

}
