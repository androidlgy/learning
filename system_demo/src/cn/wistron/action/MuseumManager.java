package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.bean.MuseumBean;
import cn.wistron.dao.MuseumDao;

public class MuseumManager extends ActionSupport {
  private List<MuseumBean> list;
  private String SearchKey;

public List<MuseumBean> getList() {
	return list;
}
public void setList(List<MuseumBean> list) {
	this.list = list;
}
public String getSearchKey() {
	return SearchKey;
}
public void setSearchKey(String searchKey) {
	SearchKey = searchKey;
}
  @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	  HttpServletResponse response =null;
	  response=ServletActionContext.getResponse();
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf-8");
	  PrintWriter out = response.getWriter();
	  HttpSession session = ServletActionContext.getRequest().getSession();
	  if(session.getAttribute("id")==null){
		  out.print("<script language='javascript'>alert('验证失败，请重新登陆');window.location='Login.jsp';</script>");
		  out.flush();
		  out.close();
		  return null;
	  }
	  String strwhere="1=1";
	  if(!isInvalid(SearchKey)){
		  strwhere+=" and Museum_Name='"+SearchKey+"'";
	  }
	  list = new MuseumDao().getList(strwhere, "Museum_Name");
	  return SUCCESS;
	}
  public static boolean isInvalid(String str){
	  return (str==null||str.length()==0);
  }
}
