package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import cn.wistron.bean.SensorBean;
import cn.wistron.utils.JdbcUtil1;
import cn.wistron.utils.JdbcUtils;
import cn.wistron.utils.PageBean;

public class SensorDao {
	public List<SensorBean> getAllList(String strwhere,String strorder){
		String sql="select * from sensormanager";
		if(!isInvalid(strwhere))
		{
			sql+=" where "+strwhere;
		}
		if(!isInvalid(strorder))
		{
			sql+=" order by "+strorder;
		}
		Connection conn = null;
		Statement stat =null;
		ResultSet rs =null;
		List<SensorBean> list = new ArrayList<SensorBean>();
		try {
			conn=JdbcUtil1.getConnection();
			stat= conn.createStatement();
			rs= stat.executeQuery(sql);
			while(rs.next()){
				SensorBean bean = new SensorBean();
				bean.setSensor_ID(rs.getInt("Sensor_ID"));
				bean.setSensor_StorehouseID(rs.getInt("Sensor_StorehouseID"));
				bean.setSensor_Name(rs.getString("Sensor_Name"));
				bean.setSensor_Type(rs.getString("Sensor_Type"));
				bean.setSensor_Unit(rs.getString("Sensor_Unit"));
				bean.setSensor_Description(rs.getString("Sensor_Description"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return list;
		
		
	}
	public List<SensorBean> getList(String strwhere,String strorder){
		String sql="select * from sensormanager,storehouse,building,museum where Sensor_StorehouseID=Storehouse_ID and Storehouse_BuildingID=Building_ID and Museum_ID=Building_MuseumID";
		
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Connection conn = null;
		Statement stat =null;
		ResultSet rs =null;
		List<SensorBean> list = new ArrayList<SensorBean>();
		try {
			conn=JdbcUtil1.getConnection();
			stat= conn.createStatement();
			rs= stat.executeQuery(sql); 
			while(rs.next()){
				SensorBean bean = new SensorBean();
				bean.setSensor_ID(rs.getInt("Sensor_ID"));
				bean.setSensor_StorehouseID(rs.getInt("Sensor_StorehouseID"));
				bean.setSensor_Name(rs.getString("Sensor_Name"));
				bean.setSensor_Type(rs.getString("Sensor_Type"));
				bean.setSensor_Unit(rs.getString("Sensor_Unit"));
				bean.setSensor_Description(rs.getString("Sensor_Description"));
				bean.setBuilding_Name(rs.getString("Building_Name"));
				bean.setStorehouse_Name(rs.getString("Storehouse_Name"));
				bean.setSensor_Type(rs.getString("Sensor_Type"));
				bean.setStorehouse_Number(rs.getString("Storehouse_Number"));
				bean.setStorehouse_Tel(rs.getString("Storehouse_Tel"));
				bean.setSensor_ReceiveTime(rs.getTimestamp("Sensor_ReceiveTime"));
				bean.setSensor_Value(rs.getString("Sensor_Value"));
				bean.setSensor_Status(rs.getBoolean("Sensor_Status"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return list;
		
	}
	
	
	//获取指定ID的实体Bean
		public SensorBean GetAllFirstBean(String strwhere){
			String sql="select * from sensormanager where "+strwhere;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = JdbcUtil1.getConnection();
			SensorBean bean = new SensorBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				if(rs.next()){
					bean.setSensor_ID(rs.getInt("Sensor_ID"));
					bean.setSensor_StorehouseID(rs.getInt("Sensor_StorehouseID"));
					bean.setSensor_Name(rs.getString("Sensor_Name"));
					bean.setSensor_Type(rs.getString("Sensor_Type"));
					bean.setSensor_Unit(rs.getString("Sensor_Unit"));
					bean.setSensor_Description(rs.getString("Sensor_Description"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat, rs);
			}
			return bean;
		}
		//获取指定ID的实体Bean
		public SensorBean GetFirstBean(String strwhere){
			String sql="select * from sensormanager,storehouse,building where Sensor_StorehouseID=Storehouse_ID and Storehouse_BuildingID=Building_ID and "+strwhere;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = JdbcUtil1.getConnection();
			SensorBean bean = new SensorBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				if(rs.next()){
					bean.setSensor_ID(rs.getInt("Sensor_ID"));
					bean.setSensor_StorehouseID(rs.getInt("Sensor_StorehouseID"));
					bean.setSensor_Name(rs.getString("Sensor_Name"));
					bean.setSensor_Type(rs.getString("Sensor_Type"));
					bean.setSensor_Unit(rs.getString("Sensor_Unit"));
					bean.setSensor_Description(rs.getString("Sensor_Description"));
					bean.setBuilding_Name(rs.getString("Building_Name"));
					bean.setStorehouse_Name(rs.getString("Storehouse_Name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat, rs);
			}
			return bean;
		}
		//获取指定ID的实体Bean
		public SensorBean GetAllBean(int id){
			String sql="select * from sensormanager where Sensor_ID="+id;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = JdbcUtil1.getConnection();
			SensorBean bean = new SensorBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					bean.setSensor_ID(rs.getInt("Sensor_ID"));
					bean.setSensor_StorehouseID(rs.getInt("Sensor_StorehouseID"));
					bean.setSensor_Name(rs.getString("Sensor_Name"));
					bean.setSensor_Type(rs.getString("Sensor_Type"));
					bean.setSensor_Unit(rs.getString("Sensor_Unit"));
					bean.setSensor_Description(rs.getString("Sensor_Description"));
					bean.setBuilding_Name(rs.getString("Building_Name"));
					bean.setStorehouse_Name(rs.getString("Storehouse_Name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat, rs);
			}
			return bean;
		}
		//获取指定ID的实体Bean
		public SensorBean GetBean(int id){
			String sql="select * from sensormanager,storehouse,building where Sensor_StorehouseID=Storehouse_ID and Storehouse_BuildingID=Building_ID and Sensor_ID="+id;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = JdbcUtil1.getConnection();
			SensorBean bean = new SensorBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					bean.setSensor_ID(rs.getInt("Sensor_ID"));
					bean.setSensor_StorehouseID(rs.getInt("Sensor_StorehouseID"));
					bean.setSensor_Name(rs.getString("Sensor_Name"));
					bean.setSensor_Type(rs.getString("Sensor_Type"));
					bean.setSensor_Unit(rs.getString("Sensor_Unit"));
					bean.setSensor_Description(rs.getString("Sensor_Description"));
					bean.setBuilding_Name(rs.getString("Building_Name"));
					bean.setStorehouse_Name(rs.getString("Storehouse_Name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat, rs);
			}
			return bean;
		}
		//获取指定ID的实体Bean
				public SensorBean Getbean(int id){
					String sql="select * from sensormanager where Sensor_ID="+id;
					Statement stat = null;
					ResultSet rs = null;
					Connection conn = JdbcUtil1.getConnection();
					SensorBean bean = new SensorBean();
					try{
						stat = conn.createStatement();
						rs = stat.executeQuery(sql);
						while(rs.next()){
							bean.setSensor_ID(rs.getInt("Sensor_ID"));
							bean.setSensor_StorehouseID(rs.getInt("Sensor_StorehouseID"));
							bean.setSensor_Name(rs.getString("Sensor_Name"));
							bean.setSensor_Type(rs.getString("Sensor_Type"));
							bean.setSensor_Unit(rs.getString("Sensor_Unit"));
							bean.setSensor_Description(rs.getString("Sensor_Description"));
						    bean.setSensor_ReceiveTime(rs.getDate("Sensor_ReceiveTime"));
						    bean.setSensor_Value(rs.getString("Sensor_Value"));
						    bean.setSensor_Status(rs.getBoolean("Sensor_Status"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						JdbcUtil1.close(conn, stat, rs);
					}
					return bean;
				}
		//添加
		public void Add(SensorBean bean){
			String sql="insert into sensormanager(Sensor_StorehouseID,Sensor_Name,Sensor_Type,Sensor_Unit,Sensor_Description) values(?,?,?,?,?)";
			PreparedStatement stat = null;
			Connection conn = JdbcUtil1.getConnection();
			try{
				stat = conn.prepareStatement(sql);
				stat.setInt(1, bean.getSensor_StorehouseID());
				stat.setString(2, bean.getSensor_Name());
				stat.setString(3, bean.getSensor_Type());
				stat.setString(4, bean.getSensor_Unit());
				stat.setString(5, bean.getSensor_Description());
				stat.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat);
				}
			
		}
		//修改
		public void Update(SensorBean bean){
			String sql="update sensormanager set Sensor_StorehouseID=?,Sensor_Name=?,Sensor_Type=?,Sensor_Unit=?,Sensor_Description=? where Sensor_ID=?";
			PreparedStatement stat = null;
			Connection conn = JdbcUtil1.getConnection();
			try{
			 stat = conn.prepareStatement(sql);
			 stat.setInt(1,bean.getSensor_StorehouseID());
			 stat.setString(2, bean.getSensor_Name());
			 stat.setString(3, bean.getSensor_Type());
			 stat.setString(4, bean.getSensor_Unit());
			 stat.setString(5, bean.getSensor_Description());
			 stat.setInt(6, bean.getSensor_ID());
			 stat.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat);
			}
		}
		//修改
		public void update(SensorBean bean){
			String sql="update sensormanager set Sensor_StorehouseID=?,Sensor_Name=?,Sensor_Type=?,Sensor_Unit=?,Sensor_Description=?,Sensor_ReceiveTime=?,Sensor_Value=?,Sensor_Status=? where Sensor_ID=?";
			PreparedStatement stat = null;
			Connection conn = JdbcUtil1.getConnection();
			try{
			 stat = conn.prepareStatement(sql);
			 stat.setInt(1,bean.getSensor_StorehouseID());
			 stat.setString(2, bean.getSensor_Name());
			 stat.setString(3, bean.getSensor_Type());
			 stat.setString(4, bean.getSensor_Unit());
			 stat.setString(5, bean.getSensor_Description());
			 stat.setTimestamp(6,new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()) );
			 stat.setString(7, bean.getSensor_Value());
			 stat.setBoolean(8, bean.isSensor_Status());
			 stat.setInt(9, bean.getSensor_ID());
		
			 stat.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat);
			}
		}
		//删除
		public void Delete(String strwhere){
			String sql="delete from sensormanager where ";
			sql+=strwhere;
			Statement stat = null;
		
			Connection conn =JdbcUtil1.getConnection();
			try{
				stat = conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil1.close(conn, stat);
			}
		}

		
		public void getAll(PageBean<SensorBean> pb,String strwhere,String strorder) {
			
			//2. 查询总记录数;  设置到pb对象中
			int totalCount = this.getTotalCount(strwhere);
			pb.setTotalCount(totalCount);
			
			/*
			 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
			 *              如果当前页为末页，再点下一页显示有问题！
			 * 解决：
			 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
			 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
			 */
			// 判断
			if (pb.getCurrentPage() <=0) {
				pb.setCurrentPage(1);					    // 把当前页设置为1
			}else if (pb.getCurrentPage() > pb.getTotalPage()){
				pb.setCurrentPage(pb.getTotalPage());		// 把当前页设置为最大页数
			}
			
			//1. 获取当前页： 计算查询的起始行、返回的行数
			int currentPage = pb.getCurrentPage();
			int index = (currentPage -1 ) * pb.getPageCount();		// 查询的起始行
			int count = pb.getPageCount();							// 查询返回的行数
			
			
			//3. 分页查询数据;  把查询到的数据设置到pb对象中
			String sql="select * from sensormanager,storehouse,building,museum where Sensor_StorehouseID=Storehouse_ID and Storehouse_BuildingID=Building_ID and Museum_ID=Building_MuseumID";
			
			if(!(isInvalid(strwhere)))
			{
				sql+=" and "+strwhere;
			}
			if(!(isInvalid(strorder)))
			{
				sql+=" order by "+strorder;
			}
			sql+=" limit ?,?";
			try {
				// 得到Queryrunner对象
				QueryRunner qr = JdbcUtils.getQueryRunner();
				// 根据当前页，查询当前页数据(一页数据)
				List<SensorBean> pageData = qr.query(sql, new BeanListHandler<SensorBean>(SensorBean.class), index, count);
				// 设置到pb对象中
				pb.setPageData(pageData);
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		}
		public int getTotalCount(String strwhere) {
			String sql = "select count(*) from sensormanager,storehouse,building,museum where Sensor_StorehouseID=Storehouse_ID and Storehouse_BuildingID=Building_ID and Museum_ID=Building_MuseumID";
			if(!(isInvalid(strwhere)))
			{
				sql+=" and "+strwhere;
			}
			try {
				// 创建QueryRunner对象
				QueryRunner qr = JdbcUtils.getQueryRunner();
				// 执行查询， 返回结果的第一行的第一列
				Long count = qr.query(sql, new ScalarHandler<Long>());
				return count.intValue();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
 public boolean isInvalid(String str){
	 return (str==null||str.length()==0);
 }
 public static void main(String[] args){
	 //List<SensorBean> list = new SensorDao().getList("", "");
	 //System.out.println(list.toString());测试使用
 }
}
