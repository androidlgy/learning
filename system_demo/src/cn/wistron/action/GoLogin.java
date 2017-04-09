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
import cn.wistron.bean.SensorBean;
import cn.wistron.dao.AdminDao;
import cn.wistron.dao.AlarmDao;
import cn.wistron.dao.BuildingDao;
import cn.wistron.dao.ManagerDao;
import cn.wistron.dao.MuseumDao;
import cn.wistron.dao.SensorDao;
import cn.wistron.dao.UserBeanDao;
import cn.wistron.utils.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class GoLogin extends ActionSupport {
	//������Action�����ڷ�װ�û��������������
	private String Type;
    private String Username;
    private String Password;
    private String Msg;
	private String SearchKey;
	private String SearchRow;
	private String Storehouse_BuildingID;
	private String Museum_ID;
	private List<BuildingBean> blist;
	private List<MuseumBean> mlist;
	
	public List<MuseumBean> getMlist() {
		return mlist;
	}
	public void setMlist(List<MuseumBean> mlist) {
		this.mlist = mlist;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	
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
	//�����û������excute����
	public String execute() throws Exception{
		HttpServletResponse response =ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(Type.equals("ϵͳ����Ա")) 
		{
			if(null==new AdminDao().CheckLogin(Username, Password)){
				Msg="�û������������";
				return INPUT;
			}else{
				String Admin_ID=new AdminDao().CheckLogin(Username, Password);
				session.setAttribute("id", Admin_ID);
				session.setAttribute("type", "1");
				session.setAttribute("Manager_Username",Username);
			    blist = new BuildingDao().getList("", "Building_Name");
				    try {
						String strwhere="1=1";
						if(!isInvalid(SearchKey)){
							strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
						}
						if(!isInvalid(Storehouse_BuildingID)){
							strwhere+=" and Storehouse_BuildingID="+Storehouse_BuildingID;
						}
						if(!isInvalid(Museum_ID)){
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
						PageBean<SensorBean> pageBean = new PageBean<SensorBean>();
						pageBean.setCurrentPage(currentPage);
						//3. ����service  
						new SensorDao().getAllAdmin(pageBean,strwhere,"Sensor_Name");    // ��pageBean�Ѿ���dao��������ݡ�
						
						//4. ����pageBean���󣬵�request����
						request.setAttribute("pageBean", pageBean);
						
						
						//5. ��ת 
					} catch (Exception e) {
						// TODO: handle exception
						throw new RuntimeException(e);
					}
					/*list=new SensorDao().getList(strwhere, "Sensor_Name");*/
				    try {
						String strwhere="1=1";
						if(!isInvalid(SearchKey)){
							strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
						}
						if(!isInvalid(Storehouse_BuildingID)){
							BuildingBean bean = new BuildingDao().getBean(Integer.parseInt(Storehouse_BuildingID));
							strwhere+=" and Alarm_BuildingName="+bean.getBuilding_Name();
						}
						if(!isInvalid(Museum_ID)){
							MuseumBean bean = new MuseumDao().getBean(Integer.parseInt(Museum_ID));
							strwhere+=" and Alarm_MuseumName="+bean.getMuseum_Name();
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
						PageBean<AlarmBean> pageBean1 = new PageBean<AlarmBean>();
						pageBean1.setCurrentPage(currentPage);
						//3. ����service  
						new AlarmDao().getAllAdmin(pageBean1,strwhere,"Alarm_MuseumName");    // ��pageBean�Ѿ���dao��������ݡ�
						
						//4. ����pageBean���󣬵�request����
						request.setAttribute("pageBean1", pageBean1);
						
						
						//5. ��ת 
					} catch (Exception e) {
						// TODO: handle exception
						throw new RuntimeException(e);
					}			
				    mlist=new MuseumDao().getList("", "Museum_Name");
				    blist = new BuildingDao().getListAdmin("", "Building_Name");
				    return SUCCESS;
			}
			
		}
		else if(Type.equals("�����ݹ���Ա"))
		{
				if(null==new ManagerDao().CheckLogin(Username, Password)){
					Msg="�û������������";
					return INPUT;
				}
				else{
					String Manager_ID = new ManagerDao().CheckLogin(Username, Password);
					session.setAttribute("id", Manager_ID);
					session.setAttribute("type", "2");
				    session.setAttribute("Manager_Username", Username);
				    try {
						String strwhere="1=1 and Manager_ID='"+session.getAttribute("id")+"'";
						if(!isInvalid(SearchKey)){
							strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
						}
						if(!isInvalid(Storehouse_BuildingID)){
							strwhere+=" and Storehouse_BuildingID="+Storehouse_BuildingID;
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
						PageBean<SensorBean> pageBean = new PageBean<SensorBean>();
						pageBean.setCurrentPage(currentPage);
						//3. ����service  
						new SensorDao().getAll(pageBean,strwhere,"Sensor_Name");    // ��pageBean�Ѿ���dao��������ݡ�
						
						//4. ����pageBean���󣬵�request����
						request.setAttribute("pageBean", pageBean);
						
						
						//5. ��ת 
					} catch (Exception e) {
						// TODO: handle exception
						throw new RuntimeException(e);
					}
					/*list=new SensorDao().getList(strwhere, "Sensor_Name");*/
				    try {
				    	MuseumBean beanByManagerID = new MuseumDao().getBeanByManagerID(Integer.parseInt(session.getAttribute("id")+""));
						String strwhere="1=1 and Alarm_MuseumName='"+beanByManagerID.getMuseum_Name()+"'";
						if(!isInvalid(SearchKey)){
							strwhere+=" and "+SearchRow+"='"+SearchKey+"'";
						}
						if(!isInvalid(Storehouse_BuildingID)){
							BuildingBean bean = new BuildingDao().getBean(Integer.parseInt(Storehouse_BuildingID));
							strwhere+=" and Alarm_BuildingName="+bean.getBuilding_Name();
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
						PageBean<AlarmBean> pageBean1 = new PageBean<AlarmBean>();
						pageBean1.setCurrentPage(currentPage);
						//3. ����service  
						new AlarmDao().getAllAdmin(pageBean1,strwhere,"Alarm_MuseumName");    // ��pageBean�Ѿ���dao��������ݡ�
						
						//4. ����pageBean���󣬵�request����
						request.setAttribute("pageBean1", pageBean1);
						
						
						//5. ��ת 
					} catch (Exception e) {
						// TODO: handle exception
						throw new RuntimeException(e);
					}			
				    blist = new BuildingDao().getList("Manager_ID='"+session.getAttribute("id")+"'", "Building_Name");
					return SUCCESS;
				}
			}
		else{
			Msg="��ݲ�ƥ�䣬����������";
			return INPUT;
		}
		
		}
	public boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
	}
    
    


