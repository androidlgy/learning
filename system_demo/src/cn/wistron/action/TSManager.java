package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.TreasuryBean;
import cn.wistron.dao.TreasuryDao;
import cn.wistron.dao.UserBeanDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class TSManager extends ActionSupport {
	private List<TreasuryBean> tlist;
	private String Storehouse_ID;
	
	public List<TreasuryBean> getTlist() {
		return tlist;
	}

	public void setTlist(List<TreasuryBean> tlist) {
		this.tlist = tlist;
	}

	public String getStorehouse_ID() {
		return Storehouse_ID;
	}

	public void setStorehouse_ID(String storehouse_ID) {
		Storehouse_ID = storehouse_ID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response =null;
		//�����������
	    response=ServletActionContext.getResponse();
	    HttpServletRequest request = ServletActionContext.getRequest();
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
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
	    //��ѯ
	    tlist = new TreasuryDao().getTRList("1=1","Treasury_ID");
	    try {
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
		    //����dao
		    new TreasuryDao().getAllTreasuryByStorehouseID(pageBean, "Storehouse_ID='"+Storehouse_ID+"'", "Treasury_ID");
		    request.setAttribute("pageBean",pageBean);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	    
		return SUCCESS;
	}

}
