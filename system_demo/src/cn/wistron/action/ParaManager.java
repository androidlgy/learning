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
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;


public class ParaManager extends ActionSupport {
	/*private List<SensorBean> list;*/
	private String SearchKey;
	private String SearchRow;
	private String Storehouse_BuildingID;
	private List<BuildingBean> blist;
	private List<MuseumBean> mlist;
	private String Museum_ID;
	

/*	public List<SensorBean> getList() {
		return list;
	}

	public void setList(List<SensorBean> list) {
		this.list = list;
	}*/
	
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

	public String getMuseum_ID() {
		return Museum_ID;
	}

	public void setMuseum_ID(String museum_ID) {
		Museum_ID = museum_ID;
	}

	public String execute() throws Exception{
	
	HttpServletResponse response =null;
	//�����������
    response=ServletActionContext.getResponse();
    response.setContentType("text/html;charset=UTF-8");
    HttpServletRequest request = ServletActionContext.getRequest();
	response.setCharacterEncoding("UTF-8");
    //��ȡ���
    PrintWriter out = response.getWriter();
    //��ȡsession
    HttpSession session = ServletActionContext.getRequest().getSession();
    if(session.getAttribute("id")==null){
    	out.print("<script language='javascript'>alert('��֤ʧ�ܣ������µ�½');window.location='Login.jsp';</script>");
    	out.flush();
    	out.close();
    	return null;
    }
    if(session.getAttribute("type").equals("1")){
    	try {
    		String strwhere="1=1";
    	    if(!(isInvalid(SearchKey))){
    	    	strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
    	    }
    	    if(!isInvalid(Storehouse_BuildingID)){
    	    	strwhere+=" and Storehouse_BuildingID="+Storehouse_BuildingID;
    	    }
    	    if(!isInvalid(Museum_ID)){
    	    	strwhere+=" and Museum_ID="+Museum_ID;
    	    }
    	    mlist=new MuseumDao().getList("", "Museum_ID");
    	    blist = new BuildingDao().getList("", "Building_Name");
    	  //1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
    		String currPage = request.getParameter("currentPage");
    		// �ж�
    		if (currPage == null || "".equals(currPage.trim())){
    			currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
    		}
    		// ת��
    		int currentPage = Integer.parseInt(currPage);
    		
    		//2. ����PageBean�������õ�ǰҳ������ ����service��������
    		PageBean<SensorBean> pageBean = new PageBean<SensorBean>();
    		pageBean.setCurrentPage(currentPage);
    		//3. ����Dao
			new SensorDao().getAllAdmin(pageBean,strwhere,"Sensor_ID");    // ��pageBean�Ѿ���dao��������ݡ�
			
			//4. ����pageBean���󣬵�request����
			request.setAttribute("pageBean", pageBean);
			//5. ��ת 
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
    
    }
    else if(session.getAttribute("type").equals("1")){
    	
    }
    return SUCCESS;

}
	public boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
}
