package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.TreasuryBean;
import cn.wistron.dao.TreasuryDao;

import com.opensymphony.xwork2.ActionSupport;

public class StorehouseAdminAdd extends ActionSupport {
	private String Treasury_Username;
	private String Treasury_Password;
	private String Treasury_Name;
	private String Treasury_Sex;
	private String Treasury_Tel;
	private String Treasury_Email;
	
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
		 HttpServletResponse response =null;
			response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = ServletActionContext.getRequest().getSession();
			PrintWriter out = response.getWriter();
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('验证不合格，请重新登陆');window.location='Login.jsp'</script>");
				out.flush();
				out.close();
				return null;
			}
			//判断用户名是否已经重复
			List<TreasuryBean> list = new TreasuryDao().getTRList("Treasury_Username='"+Treasury_Username+"' and Treasury_Name='"+Treasury_Name+"'", "Treasury_ID");
			if((list.size())>0){
				out.print("<script language='javascript'>alert('用户名已存在，请输入新的用户名');history.back(-1)</script>");
				out.flush();
				out.close();
				return null;
				}
			TreasuryBean treasuryBean = new TreasuryBean();
			treasuryBean.setTreasury_Name(Treasury_Name);
			treasuryBean.setTreasury_Password(Treasury_Password);
			treasuryBean.setTreasury_Email(Treasury_Email);
			treasuryBean.setTreasury_Sex(Treasury_Sex);
			treasuryBean.setTreasury_Tel(Treasury_Tel);
			treasuryBean.setTreasury_Username(Treasury_Username);
			new TreasuryDao().addT(treasuryBean);
			out.print("<script language='javascript'>alert('恭喜您，添加成功');window.location='StorehouseAdminManager.action'</script>");
			out.flush();
			out.close();
			return SUCCESS;
	}

}
