package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import cn.wistron.bean.AdminBean;

import cn.wistron.utils.JdbcUtil1;

public class AdminDao {
	
	
	//验证登录
	public String CheckLogin(String username, String password){
		String id = null;
		String sql="select * from admin where Admin_Username=? and Admin_Password=?";
		PreparedStatement stat = null;
		ResultSet rs = null;
		Connection conn =JdbcUtil1.getConnection();
		try{
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
		    rs = stat.executeQuery();
			while (rs.next()) {
				id = rs.getString("Admin_ID");
			}
		}
		catch(Exception e){}
		finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return id;
	}
	
	//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from admin where Admin_ID=? and Admin_Password=?";
		PreparedStatement stat = null;
		ResultSet rs = null;
		Connection conn =JdbcUtil1.getConnection();
		try{
			
			stat =conn.prepareStatement(sql);
			stat.setString(1, id);
			stat.setString(2, password);
			rs=stat.executeQuery();
			while (rs.next()) {
				ps=true;
			}
		}
		catch(Exception e){}
		finally {
			JdbcUtil1.close(conn, stat, rs);
		}
		return ps;
	}
	//获取列表
	public List<AdminBean> GetList(String strwhere,String strorder){
		String sql="select * from admin";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn =JdbcUtil1.getConnection();
		List<AdminBean> list=new ArrayList<AdminBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				AdminBean cnbean=new AdminBean();
				cnbean.setAdmin_ID(rs.getInt("Admin_ID"));
				cnbean.setAdmin_Username(rs.getString("Admin_Username"));
				cnbean.setAdmin_Password(rs.getString("Admin_Password"));
				cnbean.setAdmin_Name(rs.getString("Admin_Name"));
				cnbean.setAdmin_Sex(rs.getString("Admin_Sex"));
				cnbean.setAdmin_Tel(rs.getString("Admin_Tel"));
				cnbean.setAdmin_Email(rs.getString("Admin_Email"));
				list.add(cnbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil1.close(conn, stat, rs);
		}
		return list;
	}
	
	//获取指定ID的实体Bean
	public AdminBean GetBean(int id){
		String sql="select * from admin where Admin_ID=?";
		PreparedStatement stat = null;
		ResultSet rs = null;
		Connection conn =JdbcUtil1.getConnection();
		AdminBean cnbean=new AdminBean();
		try{
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			while(rs.next()){
				cnbean.setAdmin_ID(rs.getInt("Admin_ID"));
				cnbean.setAdmin_Username(rs.getString("Admin_Username"));
				cnbean.setAdmin_Password(rs.getString("Admin_Password"));
				cnbean.setAdmin_Name(rs.getString("Admin_Name"));
				cnbean.setAdmin_Sex(rs.getString("Admin_Sex"));
				cnbean.setAdmin_Tel(rs.getString("Admin_Tel"));
				cnbean.setAdmin_Email(rs.getString("Admin_Email"));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil1.close(conn, stat, rs);
		}
		return cnbean;
	}
	
	//添加
	public void Add(AdminBean cnbean){
		String sql="insert into admin(Admin_Username,Admin_Password,Admin_Name,Admin_Sex,Admin_Tel,Admin_Email) values(?,?,?,?,?,?)";
		PreparedStatement stat = null;
		ResultSet rs = null;
		Connection conn =JdbcUtil1.getConnection();
		try{
			stat = conn.prepareStatement(sql);
			stat.setString(1, cnbean.getAdmin_Username());
			stat.setString(2, cnbean.getAdmin_Password());
			stat.setString(3, cnbean.getAdmin_Name());
			stat.setString(4, cnbean.getAdmin_Sex());
			stat.setString(5, cnbean.getAdmin_Tel());
			stat.setString(6, cnbean.getAdmin_Email());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil1.close(conn, stat, rs);
		}
	}
	//修改
	public void Update(AdminBean cnbean){
		String sql="update admin set Admin_Username=?,Admin_Password=?,Admin_Name=?,Admin_Sex=?,Admin_Tel=?,Admin_Email=? where Admin_ID=?";
		PreparedStatement stat = null;
		ResultSet rs = null;
		Connection conn =JdbcUtil1.getConnection();
		try{
			stat = conn.prepareStatement(sql);
			stat.setString(1, cnbean.getAdmin_Username());
			stat.setString(2, cnbean.getAdmin_Password());
			stat.setString(3, cnbean.getAdmin_Name());
			stat.setString(4, cnbean.getAdmin_Sex());
			stat.setString(5, cnbean.getAdmin_Tel());
			stat.setString(6, cnbean.getAdmin_Email());
			stat.setInt(7, cnbean.getAdmin_ID());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil1.close(conn, stat, rs);
		}
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete admin where ? ";
		PreparedStatement stat = null;
		ResultSet rs = null;
		Connection conn =JdbcUtil1.getConnection();
		try{
			stat = conn.prepareStatement(sql);
			stat.setString(1, strwhere);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil1.close(conn, stat, rs);
		}
	}

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	
}

