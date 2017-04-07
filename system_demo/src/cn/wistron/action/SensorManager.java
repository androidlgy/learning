package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.MuseumBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.MuseumDao;
import cn.wistron.dao.SensorDao;
import cn.wistron.dao.StorehouseDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class SensorManager extends ActionSupport {
	private List<BuildingBean> blist;
	private String Storehouse_BuildingID;
	private String Museum_ID;
	private List<MuseumBean> mlist;
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
	
	public String getMuseum_ID() {
		return Museum_ID;
	}
	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}
	public List<MuseumBean> getMlist() {
		return mlist;
	}
	public void setMlist(List<MuseumBean> mlist) {
		this.mlist = mlist;
	}
	public String execute() throws Exception{
		HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("type")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		else if(session.getAttribute("type").equals("1")){
		blist = new BuildingDao().getListAdmin("", "Building_Name");
		mlist = new MuseumDao().getList("", "Museum_ID");
		try {
			String strwhere="1=1";
			if(!isInValid(SearchKey)){
				strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
			}
			if(!isInValid(Storehouse_BuildingID)){
				strwhere+=" and Storehouse_BuildingID="+Storehouse_BuildingID;
			}
			if(!isInValid(Museum_ID)){
				strwhere+=" and Museum_ID="+Museum_ID;
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
			//3. 调用Dao
			new SensorDao().getAllAdmin(pageBean,strwhere,"Sensor_ID");    // 【pageBean已经被dao填充了数据】
			
			//4. 保存pageBean对象，到request域中
			request.setAttribute("pageBean", pageBean);
			
			
			//5. 跳转 
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
		else if(session.getAttribute("type").equals("2")){
			blist = new BuildingDao().getList("Manager_ID="+session.getAttribute("id"), "Building_Name");
			try {
				String strwhere="1=1 and Manager_ID='"+session.getAttribute("id")+"'";
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
				
				
				//5. 跳转 
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
			
		}
		return SUCCESS;
	}
	
public boolean isInValid(String str){
	return (str==null||str.length()==0);
}	


}
