package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.TreasuryBean;
import cn.wistron.dao.TreasuryDao;

import com.opensymphony.xwork2.ActionSupport;

public class StorehouseAdminUpdate extends ActionSupport {
	private String Treasury_ID;
	private TreasuryBean tb;
	
	public String getTreasury_ID() {
		return Treasury_ID;
	}

	public void setTreasury_ID(String treasury_ID) {
		Treasury_ID = treasury_ID;
	}

	public TreasuryBean getTb() {
		return tb;
	}

	public void setTb(TreasuryBean tb) {
		this.tb = tb;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response =null;
		//避免输出乱码
	    response=ServletActionContext.getResponse();
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
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
	    tb= new TreasuryDao().getBean(Integer.parseInt(Treasury_ID));
		return SUCCESS;
	}

}
