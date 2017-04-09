package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.SensorBean;
import cn.wistron.bean.StorehouseBean;
import cn.wistron.dao.SensorDao;
import cn.wistron.dao.StorehouseDao;
import cn.wistron.dao.UserBeanDao;

import com.opensymphony.xwork2.ActionSupport;

public class SensorUpdate extends ActionSupport {
	private SensorBean sbean;
	private List<StorehouseBean> slist;
	private String Sensor_ID;
	
	public SensorBean getSbean() {
		return sbean;
	}

	public void setSbean(SensorBean sbean) {
		this.sbean = sbean;
	}

	public List<StorehouseBean> getSlist() {
		return slist;
	}

	public void setSlist(List<StorehouseBean> slist) {
		this.slist = slist;
	}

	public String getSensor_ID() {
		return Sensor_ID;
	}

	public void setSensor_ID(String sensor_ID) {
		Sensor_ID = sensor_ID;
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
				if(session.getAttribute("type")==null){
					out.print("<script language='javascript'>alert('�����µ�½��');window.location='Login.jsp';</script>");
					out.flush();
					out.close();
					return null;
				}
				else if(session.getAttribute("type").equals("1")){
				//��ѯ����
				 sbean = new SensorDao().GetBean(Integer.parseInt(Sensor_ID));
				 slist = new StorehouseDao().getList("", "Storehouse_Name");
		         
				}
				else if(session.getAttribute("type").equals("2")){
			     sbean = new SensorDao().GetBean(Integer.parseInt(Sensor_ID));
			     StorehouseBean bean = new StorehouseDao().getBean(sbean.getSensor_StorehouseID());
			     slist = new StorehouseDao().getList("Storehouse_BuildingID='"+bean.getStorehouse_BuildingID()+"'", "Storehouse_ID");
					
				}
				return SUCCESS;
			}
			
	
	//����
			public static void main(String[] args) {
					System.out.println();
				}
		}



