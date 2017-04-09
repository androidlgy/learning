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
	//���Ӳ����
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
	//�޸�museum
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
	//ɾ��museum
	public void delete(int museumid){
		String sql="delete from museum where Museum_ID=?";
		try {
			queryRunner.update(sql, museumid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//��ȡ�б�
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
	//��ȡָ��id��bean
	public MuseumBean getBean(int id){
		String sql="select * from museum where Museum_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<MuseumBean>(MuseumBean.class),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//��ȡָ���û�����bean
	public MuseumBean getBeanByManagerID(int id){
		String sql="SELECT * FROM manager ma,mm m,museum mu WHERE ma.Manager_ID=m.MM_ManagerId AND m.MM_MuseumId=mu.Museum_ID AND ma.Manager_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<MuseumBean>(MuseumBean.class),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//��ȡ����¥�����Ա��Ϣ
		public void getAllMuseum(PageBean<MuseumBean> pb,String strwhere,String strorder) {
			
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
			int count = pb.getPageCount();							// ��ѯ���ص�����
			
			
			//3. ��ҳ��ѯ����;  �Ѳ�ѯ�����������õ�pb������
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
				// �õ�Queryrunner����
				QueryRunner qr = JdbcUtils.getQueryRunner();
				// ���ݵ�ǰҳ����ѯ��ǰҳ����(һҳ����)
				List<MuseumBean> pageData = qr.query(sql, new BeanListHandler<MuseumBean>(MuseumBean.class), index, count);
				// ���õ�pb������
				pb.setPageData(pageData);
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		}
	//ͳ����������
		public int getTotalCountAdmin(String strwhere) {
			String sql = "SELECT COUNT(*) FROM museum";
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
	//�ж��Ƿ�Ϊ��
	public static boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
	public static void main(String[] args){
		/*MuseumBean bean = new MuseumDao().getBean(13);
		System.out.println(bean.getMuseum_Email());*/
		/*List<MuseumBean> list = new MuseumDao().getList("", "Museum_ID");*/
	}

}
