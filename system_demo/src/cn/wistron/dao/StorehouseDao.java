package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.wistron.bean.StorehouseBean;
import cn.wistron.utils.JdbcUtil1;

public class StorehouseDao {
	//获取列表
	public List<StorehouseBean> getList(String strwhere,String strorder){
		String sql="select * from storehouse,building,museum where Storehouse_BuildingID=Building_ID and Museum_ID=Building_MuseumID";
		if(!isInvalid(strwhere)){
			sql+=" and "+strwhere;
		}
		if(!isInvalid(strorder)){
			sql+=" order by "+strorder;
		}
		Connection conn =null;
		Statement stat =null;
		ResultSet rs=null;
	    List<StorehouseBean> list = new ArrayList<StorehouseBean>();
		try {
			conn=JdbcUtil1.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StorehouseBean storehouseBean = new StorehouseBean();
				storehouseBean.setStorehouse_ID(rs.getInt("Storehouse_ID"));
				storehouseBean.setStorehouse_BuildingID(rs.getInt("Storehouse_BuildingID"));
				storehouseBean.setStorehouse_Name(rs.getString("Storehouse_Name"));
				storehouseBean.setStorehouse_Type(rs.getString("Storehouse_Type"));
				storehouseBean.setStorehouse_Number(rs.getString("Storehouse_Number"));
				storehouseBean.setStorehouse_Tel(rs.getString("Storehouse_Tel"));
				storehouseBean.setBuilding_Name(rs.getString("Building_Name"));
				storehouseBean.setMuseum_Name(rs.getString("Museum_Name"));
			    list.add(storehouseBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		
		return list;
	}
	//获取指定id的实体bean
	public StorehouseBean getBean(int id){
		String sql="select * from storehouse,building where Storehouse_BuildingID=Building_ID and Storehouse_ID=?";
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement stat=null;
		StorehouseBean storehouseBean = new StorehouseBean();
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			while(rs.next()){
				storehouseBean.setStorehouse_ID(rs.getInt("Storehouse_ID"));
				storehouseBean.setStorehouse_BuildingID(rs.getInt("Storehouse_BuildingID"));
				storehouseBean.setStorehouse_Name(rs.getString("Storehouse_Name"));
				storehouseBean.setStorehouse_Type(rs.getString("Storehouse_Type"));
				storehouseBean.setStorehouse_Number(rs.getString("Storehouse_Number"));
				storehouseBean.setStorehouse_Tel(rs.getString("Storehouse_Tel"));
				storehouseBean.setBuilding_Name(rs.getString("Building_Name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return storehouseBean;
	}
	//增加
	public void add(StorehouseBean bean){
		String sql="insert into storehouse(Storehouse_BuildingID,Storehouse_Name,Storehouse_Type,Storehouse_Number,Storehouse_Tel) values(?,?,?,?,?)";
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setInt(1, bean.getStorehouse_BuildingID());
			stat.setString(2, bean.getStorehouse_Name());
			stat.setString(3, bean.getStorehouse_Type());
			stat.setString(4, bean.getStorehouse_Number());
			stat.setString(5, bean.getStorehouse_Tel());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
	}
	//更新
	public void update(StorehouseBean bean){
		String sql="update storehouse set Storehouse_BuildingID=?,Storehouse_Name=?,Storehouse_Type=?,Storehouse_Number=?,Storehouse_Tel=? where Storehouse_ID=?";
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setInt(1, bean.getStorehouse_BuildingID());
			stat.setString(2, bean.getStorehouse_Name());
			stat.setString(3, bean.getStorehouse_Type());
			stat.setString(4, bean.getStorehouse_Number());
			stat.setString(5, bean.getStorehouse_Tel());
			stat.setInt(6, bean.getStorehouse_ID());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
	}
	//删除
	public void delete(int id){
		String sql="delete from storehouse where Storehouse_ID=?";
		Connection conn = null;
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
		
//判空	
public boolean isInvalid(String str){
	return (str==null || str.length()==0);
    }
}
