package cn.wistron.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.MotionBean;
import cn.wistron.bean.Wav;
import cn.wistron.dao.MotionDao;

import com.opensymphony.xwork2.ActionSupport;

public class MotionUpdate extends ActionSupport {
   private MotionBean motionbean;
   private String Motion_ID;
   private List<Wav> wlist;	

	public List<Wav> getWlist() {
		return wlist;
	}

	public void setWlist(List<Wav> wlist) {
		this.wlist = wlist;
	}
	public MotionBean getMotionbean() {
		return motionbean;
	}
	public void setMotionbean(MotionBean motionbean) {
		this.motionbean = motionbean;
	}
	public String getMotion_ID() {
		return Motion_ID;
	}
	public void setMotion_ID(String motion_ID) {
		Motion_ID = motion_ID;
	}
   public String execute() throws Exception{
	   HttpServletResponse response =null;
		//避免输出乱码
	   HttpServletRequest request=null;
	    response=ServletActionContext.getResponse();
	    request=ServletActionContext.getRequest();
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
	    	
	    motionbean = new MotionDao().getBean(Integer.parseInt(Motion_ID));
	    String path=request.getSession().getServletContext().getRealPath("/wav");
	    wlist=new ArrayList<Wav>();
	    File file = new File(path);
	    File[] listFiles = file.listFiles();
	    for(int i=0;i<listFiles.length;i++){
	    	if(listFiles[i].isFile()){
	    		Wav wav = new Wav();
	    		wav.setWav_root(listFiles[i].getName());
	    		wlist.add(wav);
	    	}
	    }
	   return SUCCESS;
   }
}
