package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.wistron.bean.BuildingBean;
import cn.wistron.bean.UserBean;
import cn.wistron.utils.JdbcUtil1;
import cn.wistron.utils.JdbcUtils;

public class BuildingDao {
	private static QueryRunner queryRunner;
	static{
		queryRunner= JdbcUtils.getQueryRunner();
	}
	//增加building
	public void add(BuildingBean buildingbean ){
		String sql="insert into building(Building_Name,Building_Introduction,Building_MuseumID) values(?,?,?)";
		Connection conn =null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat = conn.prepareStatement(sql);
			stat.setString(1, buildingbean.getBuilding_Name());
			stat.setString(2, buildingbean.getBuilding_Introduction());
			stat.setInt(3, buildingbean.getBuilding_MuseumID());
			stat.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}
		
	}
	//修改building
	public void update(BuildingBean buildingbean){
		String sql="update building set Building_Name=?,Building_Introduction=?,Building_MuseumID=? where Building_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat = conn.prepareStatement(sql);
			stat.setString(1, buildingbean.getBuilding_Name());
			stat.setString(2, buildingbean.getBuilding_Introduction());
			stat.setInt(3, buildingbean.getBuilding_MuseumID());
			stat.setInt(4, buildingbean.getBuilding_ID());
			stat.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}	
		
	}
	//删除building
	public void delete(int id){
		String sql="delete from building where Building_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat = conn.prepareStatement(sql);
					stat.setInt(1, id);
			stat.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}	
	}
	//获取列表（系统管理员）
	public List<BuildingBean> getListAdmin(String strwhere,String strorder){
		String sql="select * from building,museum where Building_MuseumID=Museum_ID";
		if(!(isInvalid(strwhere))){
		sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder))){
		sql+=" order by "+strorder;
		}
		Connection conn =null;
		Statement stat =null;
		ResultSet rs =null;
		List<BuildingBean> list = new ArrayList<BuildingBean>();
		conn=JdbcUtil1.getConnection();
		try {
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				BuildingBean buildingBean = new BuildingBean();
				buildingBean.setBuilding_ID(rs.getInt("Building_ID"));
				buildingBean.setBuilding_Name(rs.getString("Building_Name"));
				buildingBean.setBuilding_Introduction(rs.getString("Building_Introduction"));
				buildingBean.setBuilding_MuseumID(rs.getInt("Building_MuseumID"));
				buildingBean.setMuseum_Name(rs.getString("Museum_Name"));
				list.add(buildingBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		
	return list;	
	}
	//获取列表(档案馆管理员)
	public List<BuildingBean> getList(String strwhere,String strorder){
		String sql="SELECT * FROM building b,museum mu,manager ma,mm mm WHERE b.Building_MuseumID=mu.Museum_ID AND mm.MM_ManagerId=ma.Manager_ID AND mm.MM_MuseumId=mu.Museum_ID";
		if(!(isInvalid(strwhere))){
		sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder))){
		sql+=" order by "+strorder;
		}
		Connection conn =null;
		Statement stat =null;
		ResultSet rs =null;
		List<BuildingBean> list = new ArrayList<BuildingBean>();
		conn=JdbcUtil1.getConnection();
		try {
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				BuildingBean buildingBean = new BuildingBean();
				buildingBean.setBuilding_ID(rs.getInt("Building_ID"));
				buildingBean.setBuilding_Name(rs.getString("Building_Name"));
				buildingBean.setBuilding_Introduction(rs.getString("Building_Introduction"));
				buildingBean.setBuilding_MuseumID(rs.getInt("Building_MuseumID"));
				buildingBean.setMuseum_Name(rs.getString("Museum_Name"));
				list.add(buildingBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		
	return list;	
	}
	//获取指定id的bean
	public BuildingBean getBean(int id){
		String sql="select * from building where Building_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		BuildingBean buildingBean=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			buildingBean = new BuildingBean();
			if(rs.next()){
				buildingBean.setBuilding_ID(rs.getInt("Building_ID"));
				buildingBean.setBuilding_Name(rs.getString("Building_Name"));
				buildingBean.setBuilding_Introduction(rs.getString("Building_Introduction"));
				buildingBean.setBuilding_MuseumID(rs.getInt("Building_MuseumID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return buildingBean;
		
	}
	//判断是否为空
	public static boolean isInvalid(String str){
		
		return (str==null||str.length()==0);
		
	}
	
	//测试
	public static void main(String[] args){
		BuildingBean bean = new BuildingDao().getBean(1);
		System.out.println(bean.getBuilding_Introduction());
	}
	public String CheckLogin(String username, String password) {
		// TODO Auto-generated method stub
		String id=null;
		String sql="select * from user where User_Username=? and User_Password=?";
		try {
		UserBean userBean = queryRunner.query(sql,new BeanHandler<UserBean>(UserBean.class), username,password);
		id=userBean.getUser_ID()+"";
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return id;
	}

}
