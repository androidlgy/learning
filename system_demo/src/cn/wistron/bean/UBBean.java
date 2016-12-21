package cn.wistron.bean;
//封装管理员和仓库的关系
public class UBBean {
	//封装对象属性
	private int UB_ID;
	private int UB_UserID;
	private int UB_BuildingID;
	public int getUB_ID() {
		return UB_ID;
	}
	public void setUB_ID(int uB_ID) {
		UB_ID = uB_ID;
	}
	public int getUB_UserID() {
		return UB_UserID;
	}
	public void setUB_UserID(int uB_UserID) {
		UB_UserID = uB_UserID;
	}
	public int getUB_BuildingID() {
		return UB_BuildingID;
	}
	public void setUB_BuildingID(int uB_BuildingID) {
		UB_BuildingID = uB_BuildingID;
	}
	private String User_Name;
	private String User_Sex;
	private String User_Tel;
	private String User_Username;
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Sex() {
		return User_Sex;
	}
	public void setUser_Sex(String user_Sex) {
		User_Sex = user_Sex;
	}
	public String getUser_Tel() {
		return User_Tel;
	}
	public void setUser_Tel(String user_Tel) {
		User_Tel = user_Tel;
	}
	public String getUser_Username() {
		return User_Username;
	}
	public void setUser_Username(String user_Username) {
		User_Username = user_Username;
	}
	private String Building_Name;
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String building_Name) {
		Building_Name = building_Name;
	} 
	
}
