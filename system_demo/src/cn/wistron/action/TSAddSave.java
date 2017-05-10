package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.TSBean;
import cn.wistron.bean.TreasuryBean;
import cn.wistron.dao.TSDao;
import cn.wistron.dao.TreasuryDao;

import com.opensymphony.xwork2.ActionSupport;

public class TSAddSave extends ActionSupport {
      private String TS_TreasuryID;
      private String TS_StorehouseID;
	public String getTS_TreasuryID() {
		return TS_TreasuryID;
	}
	public void setTS_TreasuryID(String tS_TreasuryID) {
		TS_TreasuryID = tS_TreasuryID;
	}
	public String getTS_StorehouseID() {
		return TS_StorehouseID;
	}
	public void setTS_StorehouseID(String tS_StorehouseID) {
		TS_StorehouseID = tS_StorehouseID;
	}
      @Override
    public String execute() throws Exception {
    	// TODO Auto-generated method stub
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
  	    List<TSBean> list = new TSDao().getTRList("TS_TreasuryID='"+TS_TreasuryID+"' and TS_StorehouseID='"+TS_StorehouseID+"'", "TS_ID");
  	  if(list.size()>0){
		   out.print("<script language='javascript'>alert('该管理员已经在管理本库房了，不要重复添加！');history.back(-1);</script>");
	       out.flush();
	       out.close();
	       return null;
	   }
  	  //添加
  	  TSBean tsBean = new TSBean();
  	  tsBean.setTS_StrorehouseID(Integer.parseInt(TS_StorehouseID));
  	  tsBean.setTS_TreasuryID(Integer.parseInt(TS_TreasuryID));
  	  new TSDao().add(tsBean);
  	//添加成功，跳转
	   out.print("<script language='javascript'>alert('添加成功');window.location='TSManager.action?Storehouse_ID="+TS_StorehouseID+"';</script>");
	   out.flush();out.close();
  	    return null;
    }
}
