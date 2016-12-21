package cn.wistron.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wistron.bean.MmBean;
import cn.wistron.utils.JdbcUtils;

public class MmDao {
	private static  QueryRunner queryRunner;
	static{
		queryRunner= JdbcUtils.getQueryRunner();
	}
	public List<MmBean> getList(String strwhere,String strorder){
		String sql="select * from mm,manager,museum where MM_ManagerId=Manager_ID and MM_MuseumId=Museum_ID";
		if(!isInvalid(strwhere)){
			sql+=" and "+strwhere;
		}
		if(!isInvalid(strorder)){
			sql+=" order by "+strorder;
		}
		try {
			return queryRunner.query(sql, new BeanListHandler<MmBean>(MmBean.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}
	public void add(MmBean bean){
		String sql="insert into mm(MM_ManagerId,MM_MuseumId) values(?,?)";
		try {
			queryRunner.update(sql, bean.getMM_ManagerId(),bean.getMM_MuseumId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	} 
	public void delete(int MM_ID){
		String sql="delete from mm where MM_ID=?";
		try {
			queryRunner.update(sql, MM_ID);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
   private boolean isInvalid(String str){
	   return (str==null||str.length()==0);
   }
}
