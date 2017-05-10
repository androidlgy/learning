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
		//�����������
	    response=ServletActionContext.getResponse();
	    HttpServletRequest request = ServletActionContext.getRequest();
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
	    String strwhere="1=1";
	    if(!isInvalid(SearchKey)){
	    	strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
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
  		PageBean<TreasuryBean> pageBean = new PageBean<TreasuryBean>();
  		pageBean.setCurrentPage(currentPage);
  		//���õ�ҳ��ʾ����
  		//pageBean.setPageCount(18);
  	    //3.����Dao
  		new TreasuryDao().getAllTreasury(pageBean, strwhere, "Treasury_ID");
  		//4.��ӵ�request����
  		request.setAttribute("pageBean",pageBean);
	    return SUCCESS;
	}
	//�ж��Ƿ�Ϊ��
	public static boolean isInvalid(String str){
		
		return (str==null||str.length()==0);
		
	}
}
