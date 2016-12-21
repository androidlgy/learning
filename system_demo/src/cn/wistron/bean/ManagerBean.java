package cn.wistron.bean;

public class ManagerBean {
	private int Manager_ID;
	private String Manager_Username;
	private String Manager_Password;
	private String Manager_Name;
	private String Manager_Sex;
	private String Manager_Tel;
	public int getManager_ID() {
		return Manager_ID;
	}
	public void setManager_ID(int manager_ID) {
		Manager_ID = manager_ID;
	}
	public String getManager_Username() {
		return Manager_Username;
	}
	public void setManager_Username(String manager_Username) {
		Manager_Username = manager_Username;
	}
	public String getManager_Password() {
		return Manager_Password;
	}
	public void setManager_Password(String manager_Password) {
		Manager_Password = manager_Password;
	}
	public String getManager_Name() {
		return Manager_Name;
	}
	public void setManager_Name(String manager_Name) {
		Manager_Name = manager_Name;
	}
	public String getManager_Sex() {
		return Manager_Sex;
	}
	public void setManager_Sex(String manager_Sex) {
		Manager_Sex = manager_Sex;
	}
	public String getManager_Tel() {
		return Manager_Tel;
	}
	public void setManager_Tel(String manager_Tel) {
		Manager_Tel = manager_Tel;
	}
	public ManagerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerBean(String manager_Username, String manager_Password,
			String manager_Name, String manager_Sex, String manager_Tel) {
		super();
		Manager_Username = manager_Username;
		Manager_Password = manager_Password;
		Manager_Name = manager_Name;
		Manager_Sex = manager_Sex;
		Manager_Tel = manager_Tel;
	}
	public ManagerBean(int manager_ID, String manager_Username,
			String manager_Password, String manager_Name, String manager_Sex,
			String manager_Tel) {
		super();
		Manager_ID = manager_ID;
		Manager_Username = manager_Username;
		Manager_Password = manager_Password;
		Manager_Name = manager_Name;
		Manager_Sex = manager_Sex;
		Manager_Tel = manager_Tel;
	}
	
	

}
