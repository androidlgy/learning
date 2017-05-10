package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.TreasuryBean;
import cn.wistron.dao.TreasuryDao;

import com.opensymphony.xwork2.ActionSupport;

public class StorehouseAdminUpdateSave extends ActionSupport {
	private int Treasury_ID;
	private String Treasury_Username;
	private String Treasury_Password;
	private String Treasury_Name;
	private String Treasury_Sex;
	private String Treasury_Tel;
	private String Treasury_Email;
	public int getTreasury_ID() {
		return Treasury_ID;
	}
	public void setTreasury_ID(int treasury_ID) {
		Treasury_ID = treasury_ID;
	}
	public String getTreasury_Username() {
		return Treasury_Username;
	}
	public void setTreasury_Username(String treasury_Username) {
		Treasury_Username = treasury_Username;
	}
	public String getTreasury_Password() {
		return Treasury_Password;
	}
	public void setTreasury_Password(String treasury_Password) {
		Treasury_Password = treasury_Password;
	}
	public String getTreasury_Name() {
		return Treasury_Name;
	}
	public void setTreasury_Name(String treasury_Name) {
		Treasury_Name = treasury_Name;
	}
	public String getTreasury_Sex() {
		return Treasury_Sex;
	}
	public void setTreasury_Sex(String treasury_Sex) {
		Treasury_Sex = treasury_Sex;
	}
	public String getTreasury_Tel() {
		return Treasury_Tel;
	}
	public void setTreasury_Tel(String treasury_Tel) {
		Treasury_Tel = treasury_Tel;
	}
	public String getTreasury_Email() {
		return Treasury_Email;
	}
	public void setTreasury_Email(String treasury_Email) {
		Treasury_Email = treasury_Email;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response = null;
		response= ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获得输出
		PrintWriter out = response.getWriter();
		//得到session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('验证不合格，请重新登陆！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		List<TreasuryBean> list = new TreasuryDao().getTRList("Treasury_Name='"+Treasury_Name+"' and Treasury_Username='"+Treasury_Username+"' and Treasury_ID!='"+Treasury_ID+"'", "Treasury_ID");
		if((list.size())>0){
			out.print("<script language='javascript'>alert('此用户已经存在！');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		TreasuryBean bean = new TreasuryBean();
		bean.setTreasury_Email(Treasury_Email);
		bean.setTreasury_ID(Treasury_ID);
		bean.setTreasury_Name(Treasury_Name);
		bean.setTreasury_Password(Treasury_Password);
		bean.setTreasury_Sex(Treasury_Sex);
		bean.setTreasury_Tel(Treasury_Tel);
		bean.setTreasury_Username(Treasury_Username);
		new TreasuryDao().update(bean);
		out.print("<script language='javascript'>alert('恭喜，修改成功！');window.location='StorehouseAdminManager.action';</script>");
		return null;
	}

}
