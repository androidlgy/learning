package cn.wistron.dao;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.wistron.bean.TreasuryBean;
import cn.wistron.utils.JdbcUtils;
import cn.wistron.utils.PageBean;

public class TreasuryDao {
	private static QueryRunner queryRunner;
	static{
		queryRunner=JdbcUtils.getQueryRunner();
	}
	//增加库房管理员
	public void addT(TreasuryBean tbean){
		String sql="INSERT INTO treasury(Treasury_Username,Treasury_Password,Treasury_Name,Treasury_Sex,Treasury_Tel,Treasury_Email) VALUES(?,?,?,?,?,?)";
	try {
		queryRunner.update(sql, tbean.getTreasury_Username(),tbean.getTreasury_Password(),tbean.getTreasury_Name(),tbean.getTreasury_Sex(),tbean.getTreasury_Tel(),tbean.getTreasury_Email());
		
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException(e);
	}
	}
	//修改库房管理员
	public void update(TreasuryBean tbean){
		String sql="UPDATE treasury tr SET tr.Treasury_Username=?,tr.Treasury_Password=?,tr.Treasury_Name=?,tr.Treasury_Sex=?,tr.Treasury_Tel=?,tr.Treasury_Email=? WHERE tr.Treasury_ID=?";
		try {
			queryRunner.update(sql, tbean.getTreasury_Username(),tbean.getTreasury_Password(),tbean.getTreasury_Name(),tbean.getTreasury_Sex(),tbean.getTreasury_Tel(),tbean.getTreasury_Email(),tbean.getTreasury_ID());
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//删除库房管理员
	public void delete(int treasuryid){
		String sql="DELETE FROM treasury WHERE Treasury_ID=?";
		try {
			queryRunner.update(sql, treasuryid);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//获取指定id的bean
	public TreasuryBean getBean(int treasuryid){
		String sql="SELECT * FROM treasury WHERE Treasury_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<TreasuryBean>(TreasuryBean.class),treasuryid);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//获取列表
	public List<TreasuryBean> getTRList(String strwhere,String strorder){
		String sql="SELECT * FROM treasury";
		if(!isInvalid(strwhere)){
			sql+=" where "+strwhere;
		}
		if(!isInvalid(strorder)){
			sql+=" order by "+strorder;
		}
		try {
			return queryRunner.query(sql, new BeanListHandler<TreasuryBean>(TreasuryBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}
	//获取某个库房下的库房管理员信息
	public void getAllTreasuryByStorehouseID(PageBean<TreasuryBean> pb,String strwhere,String strorder){
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCountAdminByStorehouseID(strwhere);
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
		int count = pb.getPageCount();
		//3. 分页查询数据;  把查询到的数据设置到pb对象中
		String sql="SELECT * FROM storehouse s,ts t,treasury tr WHERE s.Storehouse_ID=t.TS_StorehouseID AND tr.Treasury_ID=t.TS_TreasuryID";
		
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		sql+=" limit ?,?";
		try {
			List<TreasuryBean> pageData = queryRunner.query(sql, new BeanListHandler<TreasuryBean>(TreasuryBean.class),index,count);
			pb.setPageData(pageData);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//获取所有库房管理员信息
	public void getAllTreasury(PageBean<TreasuryBean> pb,String strwhere,String strorder){
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
		int count = pb.getPageCount();
		//3. 分页查询数据;  把查询到的数据设置到pb对象中
		String sql="select * from treasury";
		
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
			List<TreasuryBean> pageData = queryRunner.query(sql, new BeanListHandler<TreasuryBean>(TreasuryBean.class),index,count);
			pb.setPageData(pageData);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//统计数据总数
			public int getTotalCountAdmin(String strwhere) {
				String sql = "SELECT COUNT(*) FROM treasury";
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
			//统计数据总数
			public int getTotalCountAdminByStorehouseID(String strwhere) {
				String sql = "SELECT COUNT(*) FROM storehouse s,ts t,treasury tr WHERE s.Storehouse_ID=t.TS_StorehouseID AND tr.Treasury_ID=t.TS_TreasuryID";
				if(!(isInvalid(strwhere)))
				{
					sql+=" and "+strwhere;
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
		public String CheckLogin(String username, String password) {
			// TODO Auto-generated method stub
			String tresury_ID=null;
			String sql="select * from treasury where Treasury_Username=? and Treasury_Password=?";
			try {
				TreasuryBean treasuryBean = queryRunner.query(sql, new BeanHandler<TreasuryBean>(TreasuryBean.class),username,password);
				tresury_ID=treasuryBean.getTreasury_ID()+"";
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
			return tresury_ID;
		}
	
}
