package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MotionBean;
import cn.wistron.bean.SMBean;
import cn.wistron.dao.MotionDao;
import cn.wistron.dao.SMDao;

import com.opensymphony.xwork2.ActionSupport;

public class SMUpdate extends ActionSupport {
	private String SM_ID;
	private SMBean sbean;
	private List<MotionBean> mlist;
	public String getSM_ID() {
		return SM_ID;
	}
	public void setSM_ID(String sM_ID) {
		SM_ID = sM_ID;
	}
	public SMBean getSbean() {
		return sbean;
	}
	public void setSbean(SMBean sbean) {
		this.sbean = sbean;
	}
	

	public List<MotionBean> getMlist() {
		return mlist;
	}
	public void setMlist(List<MotionBean> mlist) {
		this.mlist = mlist;
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
	    mlist = new MotionDao().getList("", "");
	    sbean = new SMDao().getBean(Integer.parseInt(SM_ID));
		return SUCCESS;
	}

}
