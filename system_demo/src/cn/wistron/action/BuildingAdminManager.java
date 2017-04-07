package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.runner.Request;

import cn.wistron.bean.UserBean;
import cn.wistron.dao.UserBeanDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class BuildingAdminManager extends ActionSupport {
	//封装用户请求的数据
	private String SearchRow;
	private String SearchKey;
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	//处理用户请求的execute方法
	public String execute() throws Exception{
		//解决乱码，页面输出
		HttpServletResponse response=null;
		response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登陆
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登陆！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		else if(session.getAttribute("type").equals("1")){
			try {
				//查询条件
				String strWhere="1=1";
				if(!(isInvalid(SearchKey))){
					strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
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
				PageBean<UserBean> pageBean2 = new PageBean<UserBean>();
				pageBean2.setCurrentPage(currentPage);
				pageBean2.setPageCount(18);
				//3.调用Dao
				new UserBeanDao().getAllUser(pageBean2, strWhere, "User_ID");
				//4.保存pageBean对象，到request域中
				request.setAttribute("pageBean2",pageBean2);				
			} catch (Exception e) {		
				throw new RuntimeException(e);
			}
		}
         return SUCCESS;
	}
	
	//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
		//测试
		public static void main(String[] args) {
			System.out.println();
		}
}
