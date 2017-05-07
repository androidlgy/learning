package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.wistron.bean.MotionBean;
import cn.wistron.utils.JdbcUtil1;

public class MotionDao {
	//获取列表
	public List<MotionBean> getList(String strwhere,String strorder){
		String sql="select * from motion";
		if(!(isInvalid(strwhere))){
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder))){
			sql+=" order by "+strorder;
		}
		Connection conn =null;
		Statement stat =null;
		ResultSet rs =null;
		List<MotionBean> list = new ArrayList<MotionBean>();
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				MotionBean bean = new MotionBean();
				bean.setMotion_ID(rs.getInt("Motion_ID"));
				bean.setMotion_Name(rs.getString("Motion_Name"));
				bean.setMotion_Type(rs.getString("Motion_Type"));
				bean.setMotion_Msg(rs.getString("Motion_Msg"));
				bean.setMotion_Wav(rs.getString("Motion_Wav"));
				list.add(bean);				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
		JdbcUtil1.close(conn, stat, rs);
		}
		return list;
	}
	public boolean isInvalid(String str){
		return (str==null || str.length()==0);
	}
 //获取bean
	public MotionBean getBean(int id){
		String sql="select * from motion where Motion_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		MotionBean bean = new MotionBean();
		try {
			conn=JdbcUtil1.getConnection();
			stat= conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs= stat.executeQuery();		
			while(rs.next()){
				bean.setMotion_ID(rs.getInt("Motion_ID"));
				bean.setMotion_Name(rs.getString("Motion_Name"));
				bean.setMotion_Type(rs.getString("Motion_Type"));
				bean.setMotion_Msg(rs.getString("Motion_Msg"));
				bean.setMotion_Wav(rs.getString("Motion_Wav"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return bean;
	}
	//增加动作
	public void add(MotionBean bean){
		String sql="insert into motion(Motion_Name,Motion_Type,Motion_Msg,Motion_Wav) values(?,?,?,?)";
		Connection conn =null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setString(1, bean.getMotion_Name());
			stat.setString(2, bean.getMotion_Type());
			stat.setString(3, bean.getMotion_Msg());
			stat.setString(4, bean.getMotion_Wav());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
	}
	//修改
	public void update(MotionBean bean){
		String sql="update motion set Motion_Name=?,Motion_Type=?,Motion_Msg=?,Motion_Wav=? where Motion_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setString(1, bean.getMotion_Name());
			stat.setString(2, bean.getMotion_Type());
			stat.setString(3, bean.getMotion_Msg());
			stat.setString(4, bean.getMotion_Wav());
			stat.setInt(5, bean.getMotion_ID());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
	}
	//删除
	public void delete(int id){
		String sql="delete from motion where Motion_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
	}
}
