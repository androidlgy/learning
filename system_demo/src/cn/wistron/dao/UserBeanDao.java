package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import cn.wistron.bean.UserBean;
import cn.wistron.utils.JdbcUtil1;
import cn.wistron.utils.JdbcUtils;
import cn.wistron.utils.PageBean;

public class UserBeanDao {
	//验证登陆
	public String CheckLogin(String username,String password){
		String id=null;
		String sql="select * from user where User_Username=? and User_Password=?";
		PreparedStatement stat=null;
		ResultSet rs=null;
		Connection conn = JdbcUtil1.getConnection();
		try {
			 stat = conn.prepareStatement(sql);
			 stat.setString(1,username);
			 stat.setString(2, password);
			 rs = stat.executeQuery();
			 if(rs.next()){
			 id = rs.getString("User_ID");
			 }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	//验证密码
	public boolean CheckPassword(String id,String password){
		boolean ps=false;
		String sql="select * from user where User_ID=? and User_Password=?";
	    PreparedStatement stat=null;
	    ResultSet rs=null;
	    Connection conn = JdbcUtil1.getConnection();
	    try {
		 stat = conn.prepareStatement(sql);
		 stat.setString(1,id);
		 stat.setString(2, password);
		 rs = stat.executeQuery();
		 if(rs.next()){
			 ps=true;
		 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
	    return ps;
	}
	//获取房间管理员的列表
	public List<UserBean> GetList(String strwhere,String strorder){
		String sql="select * from user";
		if(!(isInvalid(strwhere))){
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder))){
			sql+=" order by "+strorder;
		}
		Statement stat=null;
		ResultSet rs=null;
		Connection conn =JdbcUtil1.getConnection();
		List<UserBean> list = new ArrayList<UserBean>();
	
		 try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				UserBean userBean = new UserBean();
				userBean.setUser_ID(rs.getInt("User_ID"));
				userBean.setUser_Username(rs.getString("User_Username"));
				userBean.setUser_Password(rs.getString("User_Password"));
				userBean.setUser_Name(rs.getString("User_Name"));
				userBean.setUser_Sex(rs.getString("User_Sex"));
				userBean.setUser_Tel(rs.getString("User_Tel"));
				list.add(userBean);
			}
		} catch (Exception e) {
		   throw new RuntimeException(e);
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		 return list;	
	}
	@Test
	public void test(){
		UserBean bean = new UserBeanDao().GetBean(1);
		int User_ID = bean.getUser_ID();
		System.out.println(User_ID);
		
		}
		
	//获取指定ID的实体Bean
	public UserBean GetBean(int id){
		String sql="select * from user where User_ID=?";
		PreparedStatement stat=null;
		Connection conn=null;
		ResultSet rs=null;
		UserBean userBean = new UserBean();
		try {
			conn = JdbcUtil1.getConnection();
		     stat = conn.prepareStatement(sql);
		     stat.setInt(1, id);
		      rs = stat.executeQuery();
		     if(rs.next()){		    	
			    userBean.setUser_ID(rs.getInt("User_ID"));
				userBean.setUser_Username(rs.getString("User_Username"));
				userBean.setUser_Password(rs.getString("User_Password"));
				userBean.setUser_Name(rs.getString("User_Name"));
				userBean.setUser_Sex(rs.getString("User_Sex"));
				userBean.setUser_Tel(rs.getString("User_Tel"));	    	
		     }
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return userBean;
	}
	//增加userbean
	public void Add(UserBean userbean){
		String sql="insert into user(User_Username,User_Password,User_Name,User_Sex,User_Tel) values(?,?,?,?,?)";
		PreparedStatement stat=null;
		Connection conn = JdbcUtil1.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, userbean.getUser_Username());
			stat.setString(2, userbean.getUser_Password());
			stat.setString(3, userbean.getUser_Name());
			stat.setString(4, userbean.getUser_Sex());
			stat.setString(5, userbean.getUser_Tel());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat);
		}	
	}
	//修改userbean
	public void Update(UserBean userbean){
		String sql="update user set User_Username=?,User_Password=?,User_Name=?,User_Sex=?,User_Tel=? where User_ID=? ";
		PreparedStatement stat=null;
		Connection conn = JdbcUtil1.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1,userbean.getUser_Username());
			stat.setString(2, userbean.getUser_Password());
			stat.setString(3, userbean.getUser_Name());
			stat.setString(4, userbean.getUser_Sex());
			stat.setString(5, userbean.getUser_Tel());
			stat.setInt(6, userbean.getUser_ID());
			stat.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally{
			JdbcUtil1.close(conn, stat);
		}
				
	}
	//删除
	public void delete(int id){
		String sql="delete from user where User_ID=?";
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
	//获取所有楼宇管理员信息
	public void getAllUser(PageBean<UserBean> pb,String strwhere,String strorder) {
		
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCountAdmin(strwhere);
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
		int index = (currentPage-1) * pb.getPageCount();		// 查询的起始行
		if(index<0){
			index=0;
		}
		int count = pb.getPageCount();							// 查询返回的行数
		
		
		//3. 分页查询数据;  把查询到的数据设置到pb对象中
		String sql="select * from user";
		
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
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
			List<UserBean> pageData = qr.query(sql, new BeanListHandler<UserBean>(UserBean.class), index, count);
			// 设置到pb对象中
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	//统计数据总数
	public int getTotalCountAdmin(String strwhere) {
		String sql = "SELECT COUNT(*) FROM user";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
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
	//判断
	//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
}
