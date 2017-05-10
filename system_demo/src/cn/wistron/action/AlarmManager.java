package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.AlarmBean;
import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.MuseumBean;
import cn.wistron.dao.AlarmDao;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.MuseumDao;
import cn.wistron.dao.SensorDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class AlarmManager extends ActionSupport {
	private String Museum_ID;
	private String Storehouse_BuildingID;
	private String SearchRow;
	private String SearchKey;
	private List<BuildingBean> blist;
	private List<MuseumBean> mlist;
	public String getMuseum_ID() {
		return Museum_ID;
	}
	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}
	public String getStorehouse_BuildingID() {
		return Storehouse_BuildingID;
	}
	public void setStorehouse_BuildingID(String storehouse_BuildingID) {
		Storehouse_BuildingID = storehouse_BuildingID;
	}
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	public List<BuildingBean> getBlist() {
		return blist;
	}
	public void setBlist(List<BuildingBean> blist) {
		this.blist = blist;
	}
	public List<MuseumBean> getMlist() {
		return mlist;
	}
	public void setMlist(List<MuseumBean> mlist) {
		this.mlist = mlist;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response =null;
		response=ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("type")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();
			return null;
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
			//1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
			String currPage = request.getParameter("currentPage");
			// �ж�
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
			}
			// ת��
			int currentPage = Integer.parseInt(currPage);
			
			//2. ����PageBean�������õ�ǰҳ������ ����service��������
			PageBean<AlarmBean> pageBean = new PageBean<AlarmBean>();
			pageBean.setCurrentPage(currentPage);
			//3. ����Dao
			new AlarmDao().getAllAdmin(pageBean,strwhere,"Alarm_ID");    // ��pageBean�Ѿ���dao��������ݡ�
			
			//4. ����pageBean���󣬵�request����
			request.setAttribute("pageBean", pageBean);
			
			
			//5. ��ת 
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	return SUCCESS;	
	}
	private boolean isInValid(String searchKey2) {
		// TODO Auto-generated method stub
		return (searchKey2==null||searchKey2.length()==0);
	
}
}
