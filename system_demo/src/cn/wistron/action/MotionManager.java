package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MotionBean;
import cn.wistron.dao.MotionDao;

import com.opensymphony.xwork2.ActionSupport;

public class MotionManager extends ActionSupport {

	private String SearchKey;
	private List<MotionBean> list;
	
	
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	public List<MotionBean> getList() {
		return list;
	}
	public void setList(List<MotionBean> list) {
		this.list = list;
	}

	public String execute() throws Exception{
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
		String strwhere="1=1";
		if(!isInvalid(SearchKey)){
			strwhere+=" and Motion_Type='"+SearchKey+"'";
		}
		list = new MotionDao().getList(strwhere, "Motion_Name");
		return SUCCESS;
		
	}
	public boolean isInvalid(String str){
		return (str==null || str.length()==0);
	}

}
