package cn.wistron.bean;
//封装管理员和库房的关系
public class TSBean {
	//封装对象属性
	private int TS_ID;
	private int TS_TreasuryID;
	private int TS_StrorehouseID;
	public int getTS_ID() {
		return TS_ID;
	}
	public void setTS_ID(int tS_ID) {
		TS_ID = tS_ID;
	}
	public int getTS_TreasuryID() {
		return TS_TreasuryID;
	}
	public void setTS_TreasuryID(int tS_TreasuryID) {
		TS_TreasuryID = tS_TreasuryID;
	}
	public int getTS_StrorehouseID() {
		return TS_StrorehouseID;
	}
	public void setTS_StrorehouseID(int tS_StrorehouseID) {
		TS_StrorehouseID = tS_StrorehouseID;
	}
	

}
