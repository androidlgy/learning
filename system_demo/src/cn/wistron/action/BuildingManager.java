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
	//������Action�����ڷ�װ�û��������������
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
	//ִ��execute����
	public String execute() throws Exception{
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
	   String strwhere="1=1";
	   if(!(isInvalid(SearchKey))){
		 strwhere+=" and Building_Name='"+SearchKey+"'";
	   }
	   //��ѯ����
	 
	    list = new BuildingDao().getList(strwhere,"Building_Name");
		return SUCCESS;
	}
	//�ж��Ƿ�Ϊ��
		public static boolean isInvalid(String str){
			
			return (str==null||str.length()==0);
			
		}
	

}
