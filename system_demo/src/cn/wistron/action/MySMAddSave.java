package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.SMBean;
import cn.wistron.bean.UBBean;
import cn.wistron.dao.SMDao;
import cn.wistron.dao.UBDao;

import com.opensymphony.xwork2.ActionSupport;

public class MySMAddSave extends ActionSupport {
	private String SM_MotionID;
	private String SM_SensorID;
	private String Motion_Operator;
	private String Motion_Value;
	public String getSM_MotionID() {
		return SM_MotionID;
	}
	public void setSM_MotionID(String sM_MotionID) {
		SM_MotionID = sM_MotionID;
	}
	public String getSM_SensorID() {
		return SM_SensorID;
	}
	public void setSM_SensorID(String sM_SensorID) {
		SM_SensorID = sM_SensorID;
	}
	
	public String getMotion_Operator() {
		return Motion_Operator;
	}
	public void setMotion_Operator(String motion_Operator) {
		Motion_Operator = motion_Operator;
	}
	public String getMotion_Value() {
		return Motion_Value;
	}
	public void setMotion_Value(String motion_Value) {
		Motion_Value = motion_Value;
	}
		//ִ��execute����
		public String execute() throws Exception{
			HttpServletResponse response =null;
			response = ServletActionContext.getResponse();
			//���ñ���
		    response.setContentType("text/html;charset=utf-8");
		    response.setCharacterEncoding("utf-8");
		    //��ȡ���
		    PrintWriter out = response.getWriter();
		    //��ȡsession
		    HttpSession session = ServletActionContext.getRequest().getSession();
		    //�жϵ�½״̬
		    if(session.getAttribute("id")==null){
		    	out.print("<script language='javascript'>alert('��֤ʧ�ܣ������µ�½��');window.location='Login.jsp';</script>");
		    	out.flush();
		    	out.close();
		    	return null;
		    }
		    //��֤�Ƿ����
		   List<SMBean> list = new SMDao().getList("SM_SensorID='"+SM_SensorID+"' and SM_MotionID='"+SM_MotionID+"'", "");
		   if(list.size()>0){
			   out.print("<script language='javascript'>alert('�˴������Ѿ�����˴˶�������Ҫ�ظ���ӣ�');history.back(-1);</script>");
		       out.flush();
		       out.close();
		       return null;
		   }
		   //���
           SMBean bean = new SMBean();
		   bean.setSM_MotionID(Integer.parseInt(SM_MotionID));
		   bean.setSM_SensorID(Integer.parseInt(SM_SensorID));
		   bean.setMotion_Operator(Integer.parseInt(Motion_Operator));
		   bean.setMotion_Value(Integer.parseInt(Motion_Value));
           new SMDao().add(bean);
		   //��ӳɹ�����ת
		   out.print("<script language='javascript'>alert('��ӳɹ�');window.location='MySMManager.action?Sensor_ID="+SM_SensorID+"';</script>");
		   out.flush();
	       out.close();
		   return null;
		}
	

}
