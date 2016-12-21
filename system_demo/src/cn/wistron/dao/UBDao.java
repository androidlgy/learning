package cn.wistron.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.wistron.bean.UBBean;
import cn.wistron.utils.JdbcUtil1;

public class UBDao {
	//增加
	public void add(UBBean ubbean ){
		String sql="insert into ub(UB_UserID,UB_BuildingID) values(?,?)";
		PreparedStatement stat=null;
		Connection conn = JdbcUtil1.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, ubbean.getUB_UserID());
			stat.setInt(2, ubbean.getUB_BuildingID());
			
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
		String sql="DELETE FROM ub WHERE UB_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		try {
		conn = JdbcUtil1.getConnection();
		stat = conn.prepareStatement(sql);
		stat.setInt(1, id);
		stat.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
		
	}
	//修改
	public void Update(UBBean ubbean){
		String sql="update ub set UB_UserID=?,UB_BuildingID=? where UB_ID=? ";
		PreparedStatement stat=null;
		Connection conn = JdbcUtil1.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1,ubbean.getUB_UserID());
			stat.setInt(2, ubbean.getUB_BuildingID());
			stat.setInt(3,ubbean.getUB_ID());
			stat.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally{
			JdbcUtil1.close(conn, stat);
		}
				
	}
	//获取列表
	public List<UBBean> getList(String strwhere,String strorder){
		String sql="select * from ub,user,building where UB_UserID=User_ID and UB_BuildingID=Building_ID";
		if(!(isInvalid(strwhere))){
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder))){
			sql+=" order by "+strorder;
		}
		
		Connection conn = JdbcUtil1.getConnection();
		Statement stat=null;
		ResultSet rs=null;
		List<UBBean> list = new ArrayList<UBBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				UBBean ubBean = new UBBean();
				ubBean.setBuilding_Name(rs.getString("Building_Name"));
				ubBean.setUB_BuildingID(rs.getInt("UB_BuildingID"));
				ubBean.setUB_ID(rs.getInt("UB_ID"));
				ubBean.setUB_UserID(rs.getInt("UB_UserID"));
				ubBean.setUser_Name(rs.getString("User_Name"));
				ubBean.setUser_Sex(rs.getString("User_Sex"));
				ubBean.setUser_Tel(rs.getString("User_Tel"));
				ubBean.setUser_Username(rs.getString("User_Username"));
				list.add(ubBean);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return list;
		
	}

	//根据id获取UBBean
	public UBBean getBean(int id){
		String sql="select * from ub where UB_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		UBBean ubBean = new UBBean();
	    try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			ResultSet rs =null;
			stat.setInt(1, id);
			rs = stat.executeQuery();
			while(rs.next()){
				ubBean.setUB_ID(rs.getInt("UB_ID"));
				ubBean.setUB_UserID(rs.getInt("UB_UserID"));
				ubBean.setUB_BuildingID(rs.getInt("UB_BuildingID"));
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ubBean;
	}
	
	//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
	}

