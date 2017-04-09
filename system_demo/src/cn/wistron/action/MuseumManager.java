package cn.wistron.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.wistron.bean.MuseumBean;
import cn.wistron.dao.MuseumDao;
import cn.wistron.utils.PageBean;

public class MuseumManager extends ActionSupport {
  private String SearchKey;
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
	  HttpServletRequest request = ServletActionContext.getRequest();
	  PrintWriter out = response.getWriter();
	  HttpSession session = ServletActionContext.getRequest().getSession();
	  if(session.getAttribute("id")==null){
		  out.print("<script language='javascript'>alert('��֤ʧ�ܣ������µ�½');window.location='Login.jsp';</script>");
		  out.flush();
		  out.close();
		  return null;
	  }
	  String strwhere="1=1";
	  if(!isInvalid(SearchKey)){
		  strwhere+=" and Museum_Name='"+SearchKey+"'";
	  }
	//1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
		String currPage=request.getParameter("currentPage");
		//�ж�
		if(currPage==null||"".equals(currPage.trim())){
			currPage="1";
		}
		//ת��
		int currentPage = Integer.parseInt(currPage);
		//2. ����PageBean�������õ�ǰҳ������ ����service��������
		PageBean<MuseumBean> pageBean3 = new PageBean<MuseumBean>();
		pageBean3.setCurrentPage(currentPage);
		pageBean3.setPageCount(18);
		//3.����Dao
		new MuseumDao().getAllMuseum(pageBean3, strwhere, "Museum_ID");
		//4.��ӵ�request����
		request.setAttribute("pageBean3", pageBean3);
	    return SUCCESS;
	}
  public static boolean isInvalid(String str){
	  return (str==null||str.length()==0);
  }
}
