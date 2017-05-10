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
	//���ӿⷿ����Ա
	public void addT(TreasuryBean tbean){
		String sql="INSERT INTO treasury(Treasury_Username,Treasury_Password,Treasury_Name,Treasury_Sex,Treasury_Tel,Treasury_Email) VALUES(?,?,?,?,?,?)";
	try {
		queryRunner.update(sql, tbean.getTreasury_Username(),tbean.getTreasury_Password(),tbean.getTreasury_Name(),tbean.getTreasury_Sex(),tbean.getTreasury_Tel(),tbean.getTreasury_Email());
		
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException(e);
	}
	}
	//�޸Ŀⷿ����Ա
	public void update(TreasuryBean tbean){
		String sql="UPDATE treasury tr SET tr.Treasury_Username=?,tr.Treasury_Password=?,tr.Treasury_Name=?,tr.Treasury_Sex=?,tr.Treasury_Tel=?,tr.Treasury_Email=? WHERE tr.Treasury_ID=?";
		try {
			queryRunner.update(sql, tbean.getTreasury_Username(),tbean.getTreasury_Password(),tbean.getTreasury_Name(),tbean.getTreasury_Sex(),tbean.getTreasury_Tel(),tbean.getTreasury_Email(),tbean.getTreasury_ID());
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//ɾ���ⷿ����Ա
	public void delete(int treasuryid){
		String sql="DELETE FROM treasury WHERE Treasury_ID=?";
		try {
			queryRunner.update(sql, treasuryid);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//��ȡָ��id��bean
	public TreasuryBean getBean(int treasuryid){
		String sql="SELECT * FROM treasury WHERE Treasury_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<TreasuryBean>(TreasuryBean.class),treasuryid);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//��ȡ�б�
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
	//��ȡĳ���ⷿ�µĿⷿ����Ա��Ϣ
	public void getAllTreasuryByStorehouseID(PageBean<TreasuryBean> pb,String strwhere,String strorder){
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCountAdminByStorehouseID(strwhere);
		pb.setTotalCount(totalCount);
		
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
		 */
		// �ж�
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					    // �ѵ�ǰҳ����Ϊ1
		}else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// �ѵ�ǰҳ����Ϊ���ҳ��
		}
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1) * pb.getPageCount();		// ��ѯ����ʼ��
		if(index<0){
			index=0;
		}
		int count = pb.getPageCount();
		//3. ��ҳ��ѯ����;  �Ѳ�ѯ�����������õ�pb������
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
	//��ȡ���пⷿ����Ա��Ϣ
	public void getAllTreasury(PageBean<TreasuryBean> pb,String strwhere,String strorder){
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCountAdmin(strwhere);
		pb.setTotalCount(totalCount);
		
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
		 */
		// �ж�
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					    // �ѵ�ǰҳ����Ϊ1
		}else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// �ѵ�ǰҳ����Ϊ���ҳ��
		}
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1) * pb.getPageCount();		// ��ѯ����ʼ��
		if(index<0){
			index=0;
		}
		int count = pb.getPageCount();
		//3. ��ҳ��ѯ����;  �Ѳ�ѯ�����������õ�pb������
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
	//ͳ����������
			public int getTotalCountAdmin(String strwhere) {
				String sql = "SELECT COUNT(*) FROM treasury";
				if(!(isInvalid(strwhere)))
				{
					sql+=" where "+strwhere;
				}
				try {
					// ����QueryRunner����
					QueryRunner qr = JdbcUtils.getQueryRunner();
					// ִ�в�ѯ�� ���ؽ���ĵ�һ�еĵ�һ��
					Long count = qr.query(sql, new ScalarHandler<Long>());
					return count.intValue();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			//ͳ����������
			public int getTotalCountAdminByStorehouseID(String strwhere) {
				String sql = "SELECT COUNT(*) FROM storehouse s,ts t,treasury tr WHERE s.Storehouse_ID=t.TS_StorehouseID AND tr.Treasury_ID=t.TS_TreasuryID";
				if(!(isInvalid(strwhere)))
				{
					sql+=" and "+strwhere;
				}
				try {
					// ����QueryRunner����
					QueryRunner qr = JdbcUtils.getQueryRunner();
					// ִ�в�ѯ�� ���ؽ���ĵ�һ�еĵ�һ��
					Long count = qr.query(sql, new ScalarHandler<Long>());
					return count.intValue();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
	//�ж��Ƿ�Ϊ��
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
