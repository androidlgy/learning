package cn.wistron.dao;

import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wistron.bean.ManagerBean;
import cn.wistron.utils.JdbcUtils;
public class ManagerDao {
	private static QueryRunner queryRunner;
	static{
		queryRunner = JdbcUtils.getQueryRunner();
	}
	//验证登陆
	public String CheckLogin(String username,String password){
		String id=null;
		String sql="select * from manager where Manager_Username=? and Manager_Password=?";
		 List<ManagerBean> list;
		 
		try {
			list = queryRunner.query(sql, new BeanListHandler<ManagerBean>(ManagerBean.class),username,password);
		if(list.size()>0){
			id=list.get(0).getManager_ID()+"";
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return id;
		
	}
	//验证密码
	public boolean CheckPassword(String id,String password){
		boolean flag=false;
		String sql="select * from manager where Manager_ID=? and Manager_Password=?";
		try{			
		List<ManagerBean> list = queryRunner.query(sql, new BeanListHandler<ManagerBean>(ManagerBean.class),id,password);
		if(list.size()>0){
			flag=true;
		}
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		return flag;
		
	}
	//增加博物馆
	public void add(ManagerBean manager) {
		// TODO Auto-generated method stub
         String sql="insert into manager(Manager_Username,Manager_Password,Manager_Name,Manager_Sex,Manager_Tel) values(?,?,?,?,?)";
         try {
        	 queryRunner.update(sql,manager.getManager_Username(),manager.getManager_Password(),manager.getManager_Name()
        			 ,manager.getManager_Sex(),manager.getManager_Tel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//修改museum
	public void update(ManagerBean manager){
		String sql="update manager set Manager_Username=?,Manager_Password=?,Manager_Name=?,Manager_Sex=?,Manager_Tel=? where Manager_ID=?";
		try {
			queryRunner.update(sql,manager.getManager_Username(),manager.getManager_Password(),manager.getManager_Name()
       			 ,manager.getManager_Sex(),manager.getManager_Tel(),manager.getManager_ID());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//删除museum
	public void delete(int managerid){
		String sql="delete from manager where Manager_ID=?";
		try {
			queryRunner.update(sql, managerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//获取列表
	public List<ManagerBean> getList(String strwhere,String strorder){
		String sql="select * from manager";
		if(!isInvalid(strwhere)){
			sql+=" where "+strwhere;
		}
		if(!isInvalid(strorder)){
			sql+=" order by "+strorder;
		}
		try {
			return queryRunner.query(sql,new BeanListHandler<ManagerBean>(ManagerBean.class));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	//获取指定id的bean
	public ManagerBean getBean(int id){
		String sql="select * from manager where Manager_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<ManagerBean>(ManagerBean.class),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	//判断是否为空
	public static boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
	public static void main(String[] args){
		ManagerBean bean = new ManagerDao().getBean(13);
		System.out.println(bean.getManager_Tel());
		
	}

}
