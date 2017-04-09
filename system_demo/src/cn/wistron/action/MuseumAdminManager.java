package cn.wistron.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import cn.wistron.bean.ManagerBean;
import cn.wistron.dao.ManagerDao;
import cn.wistron.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class MuseumAdminManager extends ActionSupport {
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
		// TODO Auto-generated method stub
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
	    String strWhere="1=1";
	    if(!isInvalid(SearchKey)){
	    	strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
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
	  		PageBean<ManagerBean> pageBean = new PageBean<ManagerBean>();
	  		pageBean.setCurrentPage(currentPage);
	  		pageBean.setPageCount(18);
	  		//3.����Dao
	  		new ManagerDao().getAllManager(pageBean, strWhere, "Manager_ID");
	  		//4.��ӵ�request����
	  		request.setAttribute("pageBean", pageBean);
	        return SUCCESS;
	    
		
	}
	//�ж��Ƿ�Ϊ��
			public static boolean isInvalid(String str){
				
				return (str==null||str.length()==0);
				
			}
}
