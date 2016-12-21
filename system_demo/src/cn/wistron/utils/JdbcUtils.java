package cn.wistron.utils;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 封装常用的操作
 * @author andy
 *
 */
public class JdbcUtils {
     //初始化连接池
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	/**
	 * 创建DButils工具类对象
	 * 
	 */
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
	
}
