package cn.wistron.dao;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.wistron.bean.MuseumBean;
import cn.wistron.utils.JdbcUtils;
import cn.wistron.utils.PageBean;
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
	//获取指定用户名的bean
	public MuseumBean getBeanByManagerID(int id){
		String sql="SELECT * FROM manager ma,mm m,museum mu WHERE ma.Manager_ID=m.MM_ManagerId AND m.MM_MuseumId=mu.Museum_ID AND ma.Manager_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<MuseumBean>(MuseumBean.class),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//获取所有楼宇管理员信息
		public void getAllMuseum(PageBean<MuseumBean> pb,String strwhere,String strorder) {
			
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
			String sql="select * from museum";
			
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
				List<MuseumBean> pageData = qr.query(sql, new BeanListHandler<MuseumBean>(MuseumBean.class), index, count);
				// 设置到pb对象中
				pb.setPageData(pageData);
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		}
	//统计数据总数
		public int getTotalCountAdmin(String strwhere) {
			String sql = "SELECT COUNT(*) FROM museum";
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
	//判断是否为空
	public static boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
	public static void main(String[] args){
		/*MuseumBean bean = new MuseumDao().getBean(13);
		System.out.println(bean.getMuseum_Email());*/
		/*List<MuseumBean> list = new MuseumDao().getList("", "Museum_ID");*/
	}

}
