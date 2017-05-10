package cn.wistron.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.Wav;

import com.opensymphony.xwork2.ActionSupport;

public class MotionAdd extends ActionSupport {
	private List<Wav> wlist;	

	public List<Wav> getWlist() {
		return wlist;
	}

	public void setWlist(List<Wav> wlist) {
		this.wlist = wlist;
	}

	@Override
	public String execute() throws Exception {
		HttpServletResponse response =null;
		HttpServletRequest request=null;
		//避免输出乱码
	    response=ServletActionContext.getResponse();
	    response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request=ServletActionContext.getRequest();
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
