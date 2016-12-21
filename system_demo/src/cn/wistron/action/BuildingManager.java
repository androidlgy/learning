package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import cn.wistron.bean.BuildingBean;
import cn.wistron.dao.BuildingDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BuildingManager extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private List<BuildingBean> list;
	public List<BuildingBean> getList() {
		return list;
	}
	public void setList(List<BuildingBean> list) {
		this.list = list;
	}
	private String SearchKey;
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	//执行execute方法
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
	   if(!(isInvalid(SearchKey))){
		 strwhere+=" and Building_Name='"+SearchKey+"'";
	   }
	   //查询所有
	 
	    list = new BuildingDao().getList(strwhere,"Building_Name");
		return SUCCESS;
	}
	//判断是否为空
		public static boolean isInvalid(String str){
			
			return (str==null||str.length()==0);
			
		}
	

}
