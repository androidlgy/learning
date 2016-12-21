package cn.wistron.bean;

public class SMBean {
	private int SM_ID;
	private int SM_SensorID;
	private int SM_MotionID;
	private int Motion_Operator;
	private int Motion_Value;
	public int getSM_ID() {
		return SM_ID;
	}
	public void setSM_ID(int sM_ID) {
		SM_ID = sM_ID;
	}
	public int getSM_SensorID() {
		return SM_SensorID;
	}
	public void setSM_SensorID(int sM_SensorID) {
		SM_SensorID = sM_SensorID;
	}
	public int getSM_MotionID() {
		return SM_MotionID;
	}
	public void setSM_MotionID(int sM_MotionID) {
		SM_MotionID = sM_MotionID;
	}
	private String Motion_Name;
	private String Motion_Type;
	private String Motion_Msg;
	private String Sensor_Name;

	public String getMotion_Name() {
		return Motion_Name;
	}
	public void setMotion_Name(String motion_Name) {
		Motion_Name = motion_Name;
	}
	public String getMotion_Type() {
		return Motion_Type;
	}
	public void setMotion_Type(String motion_Type) {
		Motion_Type = motion_Type;
	}
	public String getMotion_Msg() {
		return Motion_Msg;
	}
	public void setMotion_Msg(String motion_Msg) {
		Motion_Msg = motion_Msg;
	}
	public String getSensor_Name() {
		return Sensor_Name;
	}
	public void setSensor_Name(String sensor_Name) {
		Sensor_Name = sensor_Name;
	}

	public int getMotion_Operator() {
		return Motion_Operator;
	}
	public void setMotion_Operator(int motion_Operator) {
		Motion_Operator = motion_Operator;
	}
	public int getMotion_Value() {
		return Motion_Value;
	}
	public void setMotion_Value(int motion_Value) {
		Motion_Value = motion_Value;
	}
	

}
