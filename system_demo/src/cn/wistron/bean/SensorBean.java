package cn.wistron.bean;

import java.util.Date;

public class SensorBean {
	private int Sensor_ID;
	private int Sensor_StorehouseID;
	private String Sensor_Name;
	private String Sensor_Type;
	private String Sensor_Unit;
	private String Sensor_Description;
	public int getSensor_ID() {
		return Sensor_ID;
	}
	public void setSensor_ID(int sensor_ID) {
		Sensor_ID = sensor_ID;
	}
	public int getSensor_StorehouseID() {
		return Sensor_StorehouseID;
	}
	public void setSensor_StorehouseID(int sensor_StorehouseID) {
		Sensor_StorehouseID = sensor_StorehouseID;
	}
	public String getSensor_Name() {
		return Sensor_Name;
	}
	public void setSensor_Name(String sensor_Name) {
		Sensor_Name = sensor_Name;
	}
	public String getSensor_Type() {
		return Sensor_Type;
	}
	public void setSensor_Type(String sensor_Type) {
		Sensor_Type = sensor_Type;
	}
	public String getSensor_Unit() {
		return Sensor_Unit;
	}
	public void setSensor_Unit(String sensor_Unit) {
		Sensor_Unit = sensor_Unit;
	}
	public String getSensor_Description() {
		return Sensor_Description;
	}
	public void setSensor_Description(String sensor_Description) {
		Sensor_Description = sensor_Description;
	}
	private String Building_Name;
	private String Storehouse_Name;
	private String Storehouse_Type;
	private String Storehouse_Number;
	private String Storehouse_Tel;
	private int Storehouse_ID;
	private int Building_MuseumID;
	
	
	public int getStorehouse_ID() {
		return Storehouse_ID;
	}
	public void setStorehouse_ID(int storehouse_ID) {
		Storehouse_ID = storehouse_ID;
	}
	public int getBuilding_MuseumID() {
		return Building_MuseumID;
	}
	public void setBuilding_MuseumID(int building_MuseumID) {
		Building_MuseumID = building_MuseumID;
	}
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String building_Name) {
		Building_Name = building_Name;
	}
	public String getStorehouse_Name() {
		return Storehouse_Name;
	}
	public void setStorehouse_Name(String storehouse_Name) {
		Storehouse_Name = storehouse_Name;
	}
	public String getStorehouse_Type() {
		return Storehouse_Type;
	}
	public void setStorehouse_Type(String storehouse_Type) {
		Storehouse_Type = storehouse_Type;
	}
	public String getStorehouse_Number() {
		return Storehouse_Number;
	}
	public void setStorehouse_Number(String storehouse_Number) {
		Storehouse_Number = storehouse_Number;
	}
	public String getStorehouse_Tel() {
		return Storehouse_Tel;
	}
	public void setStorehouse_Tel(String storehouse_Tel) {
		Storehouse_Tel = storehouse_Tel;
	}
	
	private Date Sensor_ReceiveTime;
	private String Sensor_Value;
	private boolean Sensor_Status;
	
	public Date getSensor_ReceiveTime() {
		return Sensor_ReceiveTime;
	}
	public void setSensor_ReceiveTime(Date sensor_ReceiveTime) {
		Sensor_ReceiveTime = sensor_ReceiveTime;
	}
	public String getSensor_Value() {
		return Sensor_Value;
	}
	public void setSensor_Value(String sensor_Value) {
		Sensor_Value = sensor_Value;
	}
	public boolean isSensor_Status() {
		return Sensor_Status;
	}
	public void setSensor_Status(boolean sensor_Status) {
		Sensor_Status = sensor_Status;
	}
	private int Storehouse_BuildingID;
	private int Building_ID;
	private String building_Introduction;
	private int Museum_ID;
	private String Museum_Name;
	private String Museum_Description;
	private String Museum_Address;
	private String Museum_PhoneNumber;
	private String Museum_Email;
	public int getStorehouse_BuildingID() {
		return Storehouse_BuildingID;
	}
	public void setStorehouse_BuildingID(int storehouse_BuildingID) {
		Storehouse_BuildingID = storehouse_BuildingID;
	}
	public int getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(int building_ID) {
		Building_ID = building_ID;
	}
	public String getBuilding_Introduction() {
		return building_Introduction;
	}
	public void setBuilding_Introduction(String building_Introduction) {
		this.building_Introduction = building_Introduction;
	}
	public int getMuseum_ID() {
		return Museum_ID;
	}
	public void setMuseum_ID(int museum_ID) {
		Museum_ID = museum_ID;
	}
	public String getMuseum_Name() {
		return Museum_Name;
	}
	public void setMuseum_Name(String museum_Name) {
		Museum_Name = museum_Name;
	}
	public String getMuseum_Description() {
		return Museum_Description;
	}
	public void setMuseum_Description(String museum_Description) {
		Museum_Description = museum_Description;
	}
	public String getMuseum_Address() {
		return Museum_Address;
	}
	public void setMuseum_Address(String museum_Address) {
		Museum_Address = museum_Address;
	}
	public String getMuseum_PhoneNumber() {
		return Museum_PhoneNumber;
	}
	public void setMuseum_PhoneNumber(String museum_PhoneNumber) {
		Museum_PhoneNumber = museum_PhoneNumber;
	}
	public String getMuseum_Email() {
		return Museum_Email;
	}
	public void setMuseum_Email(String museum_Email) {
		Museum_Email = museum_Email;
	}
	

	
}
