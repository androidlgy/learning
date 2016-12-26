package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.StorehouseBean;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.StorehouseDao;
import cn.wistron.dao.UserBeanDao;

import com.opensymphony.xwork2.ActionSupport;

public class StorehouseUpdate extends ActionSupport {
	private String Storehouse_ID;
	private StorehouseBean sbean;
	private List<BuildingBean> list;
	public List<BuildingBean> getList() {
		return list;
	}
	public void setList(List<BuildingBean> list) {
		this.list = list;
	}
	public String getStorehouse_ID() {
		return Storehouse_ID;
	}
	public void setStorehouse_ID(String storehouse_ID) {
		Storehouse_ID = storehouse_ID;
	}
	public StorehouseBean getSbean() {
		return sbean;
	}
	public void setSbean(StorehouseBean sbean) {
		this.sbean = sbean;
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
				list = new BuildingDao().getList("", "Building_Name");
				//��ѯ����
				sbean = new StorehouseDao().getBean(Integer.parseInt(Storehouse_ID));
		        return SUCCESS;

			}
}
