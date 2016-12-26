package cn.wistron.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.wistron.bean.BuildingBean;
import cn.wistron.dao.BuildingDao;

import com.opensymphony.xwork2.ActionSupport;

public class BuildingAddSave extends ActionSupport {
	private String Building_MuseumID;
	private String Building_Name;
	private String Building_Introduction;
	
	public String getBuilding_MuseumID() {
		return Building_MuseumID;
	}
	public void setBuilding_MuseumID(String building_MuseumID) {
		Building_MuseumID = building_MuseumID;
	}
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String building_Name) {
		Building_Name = building_Name;
	}
	public String getBuilding_Introduction() {
		return Building_Introduction;
	}
	public void setBuilding_Introduction(String building_Introduction) {
		Building_Introduction = building_Introduction;
	}
	public String execute() throws Exception{
	//������룬ҳ�����
	HttpServletResponse response=null;
    response = ServletActionContext.getResponse();
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    
    //����session����
    HttpSession session = ServletActionContext.getRequest().getSession();
	
    //�ж��Ƿ�������½
    if(session.getAttribute("id")==null){
    	out.print("<script language='javascript'>alert('�����µ�½��');window.location='Login.jsp'; </script>");
    	out.flush();
    	out.close();
    	return null;
    }
    //����
    List<BuildingBean> list = new BuildingDao().getList("Building_Name='"+Building_Name+"'","");//�޸Ĺ�
    if(list.size()>0){
    	out.print("<script language='javascript'>alert('�����Ѵ��ڣ�');history.back(-1);</script>");
    	out.flush();
    	out.close();
    	return null;
    }
    //���
    BuildingBean bean = new BuildingBean();
    bean.setBuilding_Introduction(Building_Introduction);
    bean.setBuilding_Name(Building_Name);
    bean.setBuilding_MuseumID(Integer.parseInt(Building_MuseumID));
    new BuildingDao().add(bean);
    out.print("<script language='javascript'>alert('��ӳɹ���');window.location='BuildingManager.action';</script>");
    out.flush();
    out.close();
    return SUCCESS;

  }
}