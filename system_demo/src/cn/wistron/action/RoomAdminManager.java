package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.UserBean;
import cn.wistron.dao.UserBeanDao;

import com.opensymphony.xwork2.ActionSupport;

public class RoomAdminManager extends ActionSupport {
	//封装用户请求的数据
	private List<UserBean> list;
	private String SearchRow;
	private String SearchKey;
	public List<UserBean> getList() {
		return list;
	}
	public void setList(List<UserBean> list) {
		this.list = list;
	}
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
		//查询条件
		String strWhere="1=1";
		if(!(isInvalid(SearchKey))){
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}
		//查询所有
		 list = new UserBeanDao().GetList(strWhere,"User_Name");
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
