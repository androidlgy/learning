package cn.itcast.service.impl;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.dao.impl.EmployeeDao;
import cn.itcast.entity.Employee;
import cn.itcast.service.IEmployeeService;
import cn.itcast.utils.PageBean;

/**
 * 3. 业务逻辑层，实现
 * @author Jie.Yuan
 *
 */
public class EmployeeService implements IEmployeeService {
	
	// 创建Dao实例
	private IEmployeeDao employeeDao = new EmployeeDao();


	public void getAll(PageBean<Employee> pb) {
		try {
			employeeDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
