package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.ManagerBean;
import cn.wistron.dao.ManagerDao;

import com.opensymphony.xwork2.ActionSupport;

public class MuseumAdminManager extends ActionSupport {
	private List<ManagerBean> list;
	private String SearchKey;
	private String SearchRow;
	public List<ManagerBean> getList() {
		return list;
	}
	public void setList(List<ManagerBean> list) {
		this.list = list;
	}
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
		// TODO Auto-generated method stub
		HttpServletResponse response =null;
		//�����������
	    response=ServletActionContext.getResponse();
	    response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	    //��ȡ���
	    PrintWriter out = response.getWriter();
	    //��ȡsession
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    if(session.getAttribute("id")==null){
	    	out.print("<script language='javascript'>alert('��֤ʧ�ܣ������µ�½');window.location='Login.jsp';</script>");
	    	out.flush();
	    	out.close();
	    	return null;
	    }
	    String strWhere="1=1";
	    if(!isInvalid(SearchKey)){
	    	strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
	    }
	    list = new ManagerDao().getList(strWhere, "Manager_Name");
	    return SUCCESS;
	    
		
	}
	//�ж��Ƿ�Ϊ��
			public static boolean isInvalid(String str){
				
				return (str==null||str.length()==0);
				
			}
}
