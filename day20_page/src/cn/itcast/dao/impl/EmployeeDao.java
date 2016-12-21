package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.entity.Employee;
import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.PageBean;

/**
 * 2. 数据访问层实现
 * @author Jie.Yuan
 *
 */
public class EmployeeDao implements IEmployeeDao {


	public void getAll(PageBean<Employee> pb) {
		
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount();
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
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// 把当前页设置为最大页数
		}
		
		//1. 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// 查询的起始行
		int count = pb.getPageCount();							// 查询返回的行数
		
		
		//3. 分页查询数据;  把查询到的数据设置到pb对象中
		String sql = "select * from employee limit ?,?";
		
		try {
			// 得到Queryrunner对象
			QueryRunner qr = JdbcUtils.getQueryRuner();
			// 根据当前页，查询当前页数据(一页数据)
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class), index, count);
			// 设置到pb对象中
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	
	public int getTotalCount() {
		String sql = "select count(*) from employee";
		try {
			// 创建QueryRunner对象
			QueryRunner qr = JdbcUtils.getQueryRuner();
			// 执行查询， 返回结果的第一行的第一列
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}














