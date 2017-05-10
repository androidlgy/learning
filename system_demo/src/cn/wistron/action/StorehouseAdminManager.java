package cn.wistron.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.TreasuryBean;
import cn.wistron.dao.TreasuryDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class StorehouseAdminManager extends ActionSupport {
	private String SearchKey;
	private String SearchRow;
	
	public String getSearchKey() {
		return SearchKey;
	}

	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}

	public String getSearchRow() {
		return SearchRow;
	}

	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}

	@Override
	public String execute() throws Exception {
		HttpServletResponse response =null;
		//避免输出乱码
	    response=ServletActionContext.getResponse();
	    HttpServletRequest request = ServletActionContext.getRequest();
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
	    	strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
	    }
	    //1. 获取“当前页”参数；  (第一次访问当前页为null) 
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
  		//设置单页显示条数
  		//pageBean.setPageCount(18);
  	    //3.调用Dao
  		new TreasuryDao().getAllTreasury(pageBean, strwhere, "Treasury_ID");
  		//4.添加到request域中
  		request.setAttribute("pageBean",pageBean);
	    return SUCCESS;
	}
	//判断是否为空
	public static boolean isInvalid(String str){
		
		return (str==null||str.length()==0);
		
	}
}
