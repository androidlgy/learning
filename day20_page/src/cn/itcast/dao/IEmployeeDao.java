package cn.itcast.dao;

import cn.itcast.entity.Employee;
import cn.itcast.utils.PageBean;

/**
 * 2. 数据访问层，接口设计
 * @author Jie.Yuan
 *
 */
public interface IEmployeeDao {

	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<Employee> pb);
	
	/**
	 * 查询总记录数
	 */
	public int getTotalCount();
}









