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
	//��װ�û����������
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
	//�����û������execute����
	public String execute() throws Exception{
		//������룬ҳ�����
		HttpServletResponse response=null;
		response = ServletActionContext.getResponse();
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
		//��ѯ����
		String strWhere="1=1";
		if(!(isInvalid(SearchKey))){
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}
		//��ѯ����
		 list = new UserBeanDao().GetList(strWhere,"User_Name");
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
