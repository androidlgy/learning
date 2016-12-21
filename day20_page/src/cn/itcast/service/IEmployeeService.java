package cn.itcast.service;

import cn.itcast.entity.Employee;
import cn.itcast.utils.PageBean;

/**
 * 3. 业务逻辑层接口设计
 * @author Jie.Yuan
 *
 */
public interface IEmployeeService {

	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<Employee> pb);
}
