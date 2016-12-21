package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.SensorDao;
import cn.wistron.dao.StorehouseDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class SensorManager extends ActionSupport {
	private List<BuildingBean> blist;
	private String Storehouse_BuildingID;
	private String SearchKey;
	private String SearchRow;
	public List<BuildingBean> getBlist() {
		return blist;
	}
	public void setBlist(List<BuildingBean> blist) {
		this.blist = blist;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	
	public String getStorehouse_BuildingID() {
		return Storehouse_BuildingID;
	}
	public void setStorehouse_BuildingID(String storehouse_BuildingID) {
		Storehouse_BuildingID = storehouse_BuildingID;
	}
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		blist = new BuildingDao().getList("", "Building_Name");
		try {
			String strwhere="1=1";
			if(!isInValid(SearchKey)){
				strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
			}
			if(!isInValid(Storehouse_BuildingID)){
				strwhere+=" and Storehouse_BuildingID="+Storehouse_BuildingID;
			}
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			String currPage = request.getParameter("currentPage");
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// 第一次访问，设置当前页为1;
			}
			// 转换
			int currentPage = Integer.parseInt(currPage);
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean<SensorBean> pageBean = new PageBean<SensorBean>();
			pageBean.setCurrentPage(currentPage);
			//3. 调用service  
			new SensorDao().getAll(pageBean,strwhere,"Sensor_Name");    // 【pageBean已经被dao填充了数据】
			
			//4. 保存pageBean对象，到request域中
			request.setAttribute("pageBean", pageBean);
			return SUCCESS;
			
			//5. 跳转 
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
public boolean isInValid(String str){
	return (str==null||str.length()==0);
}	


}
