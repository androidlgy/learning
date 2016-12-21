package cn.wistron.dao;

import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wistron.bean.MuseumBean;
import cn.wistron.utils.JdbcUtils;
public class MuseumDao {
	private static QueryRunner queryRunner;
	static{
		queryRunner = JdbcUtils.getQueryRunner();
	}
	//增加博物馆
	public void add(MuseumBean museumbean) {
		// TODO Auto-generated method stub
         String sql="insert into museum(Museum_Name,Museum_Description,Museum_Address,Museum_PhoneNumber,Museum_Email) values(?,?,?,?,?)";
         try {
        	 queryRunner.update(sql, museumbean.getMuseum_Name(),
					museumbean.getMuseum_Description(),museumbean.getMuseum_Address(),museumbean.getMuseum_PhoneNumber(),museumbean.getMuseum_Email());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//修改museum
	public void update(MuseumBean museumbean){
		String sql="update museum set Museum_Name=?,Museum_Description=?,Museum_Address=?,Museum_PhoneNumber=?,Museum_Email=? where Museum_ID=?";
		try {
			queryRunner.update(sql,museumbean.getMuseum_Name(),museumbean.getMuseum_Description(),
					museumbean.getMuseum_Address(),museumbean.getMuseum_PhoneNumber(),museumbean.getMuseum_Email(),museumbean.getMuseum_ID());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//删除museum
	public void delete(int museumid){
		String sql="delete from museum where Museum_ID=?";
		try {
			queryRunner.update(sql, museumid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//获取列表
	public List<MuseumBean> getList(String strwhere,String strorder){
		String sql="select * from museum";
		if(!isInvalid(strwhere)){
			sql+=" where "+strwhere;
		}
		if(!isInvalid(strorder)){
			sql+=" order by "+strorder;
		}
		try {
			return queryRunner.query(sql,new BeanListHandler<MuseumBean>(MuseumBean.class));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	//获取指定id的bean
	public MuseumBean getBean(int id){
		String sql="select * from museum where Museum_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<MuseumBean>(MuseumBean.class),id);
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
		MuseumBean bean = new MuseumDao().getBean(13);
		System.out.println(bean.getMuseum_Email());
		
	}

}
