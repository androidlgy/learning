package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MotionBean;
import cn.wistron.bean.SMBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.MotionDao;
import cn.wistron.dao.SMDao;
import cn.wistron.dao.SensorDao;

import com.opensymphony.xwork2.ActionSupport;

public class SMManager extends ActionSupport {
	private String Sensor_ID;
	private List<SMBean>  smlist;
	private List<MotionBean> molist;
	private SensorBean sbean;
	public String getSensor_ID() {
		return Sensor_ID;
	}
	public void setSensor_ID(String sensor_ID) {
		Sensor_ID = sensor_ID;
	}
	public List<SMBean> getSmlist() {
		return smlist;
	}
	public void setSmlist(List<SMBean> smlist) {
		this.smlist = smlist;
	}
	public List<MotionBean> getMolist() {
		return molist;
	}
	public void setMolist(List<MotionBean> molist) {
		this.molist = molist;
	}
	
	public SensorBean getSbean() {
		return sbean;
	}
	public void setSbean(SensorBean sbean) {
		this.sbean = sbean;
	}
		//ִ��execute����
		public String execute() throws Exception{
			HttpServletResponse response =null;
			//�����������
		    response=ServletActionContext.getResponse();
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
		    molist=  new MotionDao().getList("", "");
		    smlist= new SMDao().getList("SM_SensorID="+Sensor_ID, "");
		    sbean = new SensorDao().Getbean(Integer.parseInt(Sensor_ID));
		    return SUCCESS;
		    

    }
}
