package cn.wistron.bean;

import java.util.Date;

public class AlarmBean {
	private int Alarm_ID;
	private int Alarm_SensorId;
	private int Alarm_MuseumId;
	private int Alarm_BuildingId;
	private Date Alarm_Time;
	private String Alarm_Thing;
	private String Alarm_Value;
	public int getAlarm_ID() {
		return Alarm_ID;
	}
	public void setAlarm_ID(int alarm_ID) {
		Alarm_ID = alarm_ID;
	}
	public int getAlarm_SensorId() {
		return Alarm_SensorId;
	}
	public void setAlarm_SensorId(int alarm_SensorId) {
		Alarm_SensorId = alarm_SensorId;
	}
	public int getAlarm_MuseumId() {
		return Alarm_MuseumId;
	}
	public void setAlarm_MuseumId(int alarm_MuseumId) {
		Alarm_MuseumId = alarm_MuseumId;
	}
	public int getAlarm_BuildingId() {
		return Alarm_BuildingId;
	}
	public void setAlarm_BuildingId(int alarm_BuildingId) {
		Alarm_BuildingId = alarm_BuildingId;
	}
	public Date getAlarm_Time() {
		return Alarm_Time;
	}
	public void setAlarm_Time(Date alarm_Time) {
		Alarm_Time = alarm_Time;
	}
	public String getAlarm_Thing() {
		return Alarm_Thing;
	}
	public void setAlarm_Thing(String alarm_Thing) {
		Alarm_Thing = alarm_Thing;
	}
	public String getAlarm_Value() {
		return Alarm_Value;
	}
	public void setAlarm_Value(String alarm_Value) {
		Alarm_Value = alarm_Value;
	}
	

}
