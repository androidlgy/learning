package cn.wistron.bean;
import java.util.Date;
public class AlarmBean {
	private int Alarm_ID;
	private int Alarm_SensorId;
	private String Alarm_SensorName;
	private String Alarm_MuseumName;
	private String Alarm_BuildingName;
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

	public String getAlarm_MuseumName() {
		return Alarm_MuseumName;
	}
	public void setAlarm_MuseumName(String alarm_MuseumName) {
		Alarm_MuseumName = alarm_MuseumName;
	}
	public String getAlarm_BuildingName() {
		return Alarm_BuildingName;
	}
	public void setAlarm_BuildingName(String alarm_BuildingName) {
		Alarm_BuildingName = alarm_BuildingName;
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
	public String getAlarm_SensorName() {
		return Alarm_SensorName;
	}
	public void setAlarm_SensorName(String alarm_SensorName) {
		Alarm_SensorName = alarm_SensorName;
	}
	

}
