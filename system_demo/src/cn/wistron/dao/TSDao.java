package cn.wistron.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wistron.bean.TSBean;
import cn.wistron.bean.TreasuryBean;
import cn.wistron.utils.JdbcUtils;

public class TSDao {
	private static QueryRunner queryRunner;
	static{
		queryRunner = JdbcUtils.getQueryRunner();
	}
	//增加
	public void add(TSBean bean){
		String sql="INSERT INTO ts(ts.TS_StorehouseID,ts.TS_TreasuryID) VALUES(?,?)";
		try {
			queryRunner.update(sql, bean.getTS_StrorehouseID(),bean.getTS_TreasuryID());
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	public void delete(int tsid){
		String sql="DELETE FROM ts WHERE TS_ID=?";
		try {
			queryRunner.update(sql, tsid);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//获取列表
		public List<TSBean> getTRList(String strwhere,String strorder){
			String sql="SELECT * FROM ts";
			if(!isInvalid(strwhere)){
				sql+=" where "+strwhere;
			}
			if(!isInvalid(strorder)){
				sql+=" order by "+strorder;
			}
			try {
				return queryRunner.query(sql, new BeanListHandler<TSBean>(TSBean.class));
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
			
		}
		//判断是否为空
				public static boolean isInvalid(String str){
					return (str==null||str.length()==0);
				}
}
