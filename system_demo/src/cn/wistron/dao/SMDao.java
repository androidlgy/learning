package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.wistron.bean.SMBean;
import cn.wistron.utils.JdbcUtil1;

public class SMDao {
	public List<SMBean> getList(String strwhere,String strorder){
		String sql="select * from sm,sensormanager,motion where SM_MotionID=Motion_ID and SM_SensorID=Sensor_ID";
		if(!isInValid(strwhere)){
			sql+=" and "+strwhere;
		}
		if(!isInValid(strorder)){
			sql+=" order by "+strorder;
		}
		Connection conn =null;
		Statement stat =null;
		ResultSet rs =null;
		List<SMBean> smlist = new ArrayList<SMBean>();
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				SMBean bean = new SMBean();
				bean.setSM_ID(rs.getInt("SM_ID"));
				bean.setSM_MotionID(rs.getInt("SM_MotionID"));
				bean.setSM_SensorID(rs.getInt("SM_SensorID"));
				bean.setMotion_Name(rs.getString("Motion_Name"));
				bean.setMotion_Type(rs.getString("Motion_Type"));
				bean.setMotion_Msg(rs.getString("Motion_Msg"));
				bean.setSensor_Name(rs.getString("Sensor_Name"));
				bean.setMotion_Operator(rs.getInt("Motion_Operator"));
				bean.setMotion_Value(rs.getInt("Motion_Value"));
				smlist.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return smlist;
	}
	public void add(SMBean smbean){
		String sql="insert into sm(SM_MotionID,SM_SensorID,Motion_Operator,Motion_Value) values(?,?,?,?)";
		Connection conn =null;
		PreparedStatement stat =null;
		try {
			conn=JdbcUtil1.getConnection();
			 stat=conn.prepareStatement(sql);
			 stat.setInt(1, smbean.getSM_MotionID());
			 stat.setInt(2, smbean.getSM_SensorID());
			 stat.setInt(3, smbean.getMotion_Operator());
			 stat.setInt(4, smbean.getMotion_Value());
			 stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
	}
	public SMBean getBean(int id){
		String sql="select * from sm where SM_ID=?";
		Connection conn =null;
		PreparedStatement stat =null;
		ResultSet rs =null;
		SMBean bean = new SMBean();
		try {
			conn=JdbcUtil1.getConnection();
			 stat=conn.prepareStatement(sql);
			 stat.setInt(1, id);
			 rs=stat.executeQuery();
			
			 while(rs.next()){
				 bean.setSM_ID(rs.getInt("SM_ID"));
				 bean.setSM_MotionID(rs.getInt("SM_MotionID"));
				 bean.setSM_SensorID(rs.getInt("SM_SensorID"));
				 bean.setMotion_Operator(rs.getInt("Motion_Operator"));
				 bean.setMotion_Value(rs.getInt("Motion_Value"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
		return bean;
	}
	public void update(SMBean bean){
		String sql="update sm set SM_MotionID=?,SM_SensorID=?,Motion_Operator=?,Motion_Value=? where SM_ID=?";
		Connection conn =null;
		PreparedStatement stat =null;
		try {
			conn=JdbcUtil1.getConnection();
			 stat=conn.prepareStatement(sql);
			 stat.setInt(1, bean.getSM_MotionID());
			 stat.setInt(2, bean.getSM_SensorID());
			 stat.setInt(3, bean.getMotion_Operator());
			 stat.setInt(4, bean.getMotion_Value());
			 stat.setInt(5, bean.getSM_ID());
		     stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
	}
	public void delete(int id){
		String sql="delete from sm where SM_ID=?";
		Connection conn =null;
		PreparedStatement stat =null;
		try {
			conn=JdbcUtil1.getConnection();
			 stat=conn.prepareStatement(sql);
			 stat.setInt(1,id);
		     stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
		
	}
	public SMBean getBean1(int id){
		String sql="SELECT * FROM sm,motion WHERE Motion_ID=SM_MotionID AND SM_SensorID=?";
		Connection conn =null;
		PreparedStatement stat =null;
		ResultSet rs =null;
		SMBean bean = new SMBean();
		try {
			conn=JdbcUtil1.getConnection();
			 stat=conn.prepareStatement(sql);
			 stat.setInt(1, id);
			 rs=stat.executeQuery();
			
			 while(rs.next()){
				 bean.setSM_ID(rs.getInt("SM_ID"));
				 bean.setSM_MotionID(rs.getInt("SM_MotionID"));
				 bean.setSM_SensorID(rs.getInt("SM_SensorID"));
				 bean.setMotion_Operator(rs.getInt("Motion_Operator"));
				 bean.setMotion_Value(rs.getInt("Motion_Value"));
				 bean.setMotion_Msg(rs.getString("Motion_Msg"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
		return bean;
	}
    public boolean isInValid(String str){
	return (str==null||str.length()==0);
  }
}
