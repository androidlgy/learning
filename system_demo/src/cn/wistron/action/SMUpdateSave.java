package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.SMBean;
import cn.wistron.dao.MotionDao;
import cn.wistron.dao.SMDao;

import com.opensymphony.xwork2.ActionSupport;

public class SMUpdateSave extends ActionSupport {
	private String SM_ID;
	private String SM_MotionID;
	private String Motion_Operator;
	private String Motion_Value;
	private String SM_SensorID;

	public String getSM_ID() {
		return SM_ID;
	}

	public void setSM_ID(String sM_ID) {
		SM_ID = sM_ID;
	}

	public String getSM_MotionID() {
		return SM_MotionID;
	}

	public void setSM_MotionID(String sM_MotionID) {
		SM_MotionID = sM_MotionID;
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

	public String getSM_SensorID() {
		return SM_SensorID;
	}

	public void setSM_SensorID(String sM_SensorID) {
		SM_SensorID = sM_SensorID;
	}

	public String execute() throws Exception{
		HttpServletResponse response =null;
		//避免输出乱码
	    response=ServletActionContext.getResponse();
	    response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	    //获取输出
	    PrintWriter out = response.getWriter();
	    //获取session
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    if(session.getAttribute("id")==null){
	    	out.print("<script language='javascript'>alert('验证失败，请重新登陆');window.location='Login.jsp';</script>");
	    	out.flush();
	    	out.close();
	    	return null;
	    }
	    List<SMBean> list = new SMDao().getList("SM_MotionID='"+SM_MotionID+"' and SM_SensorID='"+SM_SensorID+"' and SM_ID!='"+SM_ID+"'", "");
	    if(list.size()>0){
	    	out.print("<script language='javascript'>alert('对不起，此触发动作已经存在！');history.back(-1);</script>");
	    	out.flush();
	    	out.close();
	    	return null;
	    }
	    SMBean bean = new SMBean();
	    bean.setSM_ID(Integer.parseInt(SM_ID));
	    bean.setSM_MotionID(Integer.parseInt(SM_MotionID));
	    bean.setSM_SensorID(Integer.parseInt(SM_SensorID));
	    bean.setMotion_Operator(Integer.parseInt(Motion_Operator));
	    bean.setMotion_Value(Integer.parseInt(Motion_Value));
	    new SMDao().update(bean);
	    out.print("<script language='javascript'>alert('恭喜你，修改成功！');window.location='SMManager.action?Sensor_ID="+SM_SensorID+"';</script>");
    	out.flush();
    	out.close();
	    return null;
	}


}
