package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.TreasuryBean;
import cn.wistron.dao.TreasuryDao;
import cn.wistron.dao.UserBeanDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class TSManager extends ActionSupport {
	private List<TreasuryBean> tlist;
	private String Storehouse_ID;
	
	public List<TreasuryBean> getTlist() {
		return tlist;
	}

	public void setTlist(List<TreasuryBean> tlist) {
		this.tlist = tlist;
	}

	public String getStorehouse_ID() {
		return Storehouse_ID;
	}

	public void setStorehouse_ID(String storehouse_ID) {
		Storehouse_ID = storehouse_ID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response =null;
		//避免输出乱码
	    response=ServletActionContext.getResponse();
	    HttpServletRequest request = ServletActionContext.getRequest();
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
	    //查询
	    tlist = new TreasuryDao().getTRList("1=1","Treasury_ID");
	    try {
	    	String currPage=request.getParameter("currentPage");
			//判断
			if(currPage==null||"".equals(currPage.trim())){
				currPage="1";
			}
			//转换
			int currentPage = Integer.parseInt(currPage);
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
		    PageBean<TreasuryBean> pageBean = new PageBean<TreasuryBean>();
		    pageBean.setCurrentPage(currentPage);
		    //调用dao
		    new TreasuryDao().getAllTreasuryByStorehouseID(pageBean, "Storehouse_ID='"+Storehouse_ID+"'", "Treasury_ID");
		    request.setAttribute("pageBean",pageBean);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	    
		return SUCCESS;
	}

}
