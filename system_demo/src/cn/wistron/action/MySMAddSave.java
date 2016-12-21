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
		//执行execute方法
		public String execute() throws Exception{
			HttpServletResponse response =null;
			response = ServletActionContext.getResponse();
			//设置编码
		    response.setContentType("text/html;charset=utf-8");
		    response.setCharacterEncoding("utf-8");
		    //获取输出
		    PrintWriter out = response.getWriter();
		    //获取session
		    HttpSession session = ServletActionContext.getRequest().getSession();
		    //判断登陆状态
		    if(session.getAttribute("id")==null){
		    	out.print("<script language='javascript'>alert('验证失败，请重新登陆！');window.location='Login.jsp';</script>");
		    	out.flush();
		    	out.close();
		    	return null;
		    }
		    //验证是否存在
		   List<SMBean> list = new SMDao().getList("SM_SensorID='"+SM_SensorID+"' and SM_MotionID='"+SM_MotionID+"'", "");
		   if(list.size()>0){
			   out.print("<script language='javascript'>alert('此传感器已经添加了此动作，不要重复添加！');history.back(-1);</script>");
		       out.flush();
		       out.close();
		       return null;
		   }
		   //添加
           SMBean bean = new SMBean();
		   bean.setSM_MotionID(Integer.parseInt(SM_MotionID));
		   bean.setSM_SensorID(Integer.parseInt(SM_SensorID));
		   bean.setMotion_Operator(Integer.parseInt(Motion_Operator));
		   bean.setMotion_Value(Integer.parseInt(Motion_Value));
           new SMDao().add(bean);
		   //添加成功，跳转
		   out.print("<script language='javascript'>alert('添加成功');window.location='MySMManager.action?Sensor_ID="+SM_SensorID+"';</script>");
		   out.flush();
	       out.close();
		   return null;
		}
	

}
