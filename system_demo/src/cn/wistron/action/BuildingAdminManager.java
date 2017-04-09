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
	//��װ�û����������
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
	//�����û������execute����
	public String execute() throws Exception{
		//������룬ҳ�����
		HttpServletResponse response=null;
		response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������½
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�½��');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		else if(session.getAttribute("type").equals("1")){
			try {
				//��ѯ����
				String strWhere="1=1";
				if(!(isInvalid(SearchKey))){
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
				PageBean<UserBean> pageBean2 = new PageBean<UserBean>();
				pageBean2.setCurrentPage(currentPage);
				pageBean2.setPageCount(18);
				//3.����Dao
				new UserBeanDao().getAllUser(pageBean2, strWhere, "User_ID");
				//4.����pageBean���󣬵�request����
				request.setAttribute("pageBean2",pageBean2);				
			} catch (Exception e) {		
				throw new RuntimeException(e);
			}
		}
         return SUCCESS;
	}
	
	//�ж��Ƿ��ֵ
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
		//����
		public static void main(String[] args) {
			System.out.println();
		}
}
