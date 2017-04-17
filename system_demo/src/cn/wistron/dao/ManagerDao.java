package cn.wistron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.wistron.bean.ManagerBean;
import cn.wistron.bean.MotionBean;
import cn.wistron.utils.JdbcUtil1;
import cn.wistron.utils.JdbcUtils;
import cn.wistron.utils.PageBean;
public class ManagerDao {
	private static QueryRunner queryRunner;
	static{
		queryRunner = JdbcUtils.getQueryRunner();
	}
	//��֤��½
	public String CheckLogin(String username,String password){
		String id=null;
		String sql="select * from manager where Manager_Username=? and Manager_Password=?";
		 List<ManagerBean> list;
		 
		try {
			list = queryRunner.query(sql, new BeanListHandler<ManagerBean>(ManagerBean.class),username,password);
		if(list.size()>0){
			id=list.get(0).getManager_ID()+"";
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return id;
		
	}
	//��֤����
	public boolean CheckPassword(String id,String password){
		boolean flag=false;
		String sql="select * from manager where Manager_ID=? and Manager_Password=?";
		try{			
		List<ManagerBean> list = queryRunner.query(sql, new BeanListHandler<ManagerBean>(ManagerBean.class),id,password);
		if(list.size()>0){
			flag=true;
		}
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		return flag;
		
	}
	//���Ӳ����
	public void add(ManagerBean manager) {
		// TODO Auto-generated method stub
         String sql="insert into manager(Manager_Username,Manager_Password,Manager_Name,Manager_Sex,Manager_Tel) values(?,?,?,?,?)";
         try {
        	 queryRunner.update(sql,manager.getManager_Username(),manager.getManager_Password(),manager.getManager_Name()
        			 ,manager.getManager_Sex(),manager.getManager_Tel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//�޸�museum
	public void update(ManagerBean manager){
		String sql="update manager set Manager_Username=?,Manager_Password=?,Manager_Name=?,Manager_Sex=?,Manager_Tel=? where Manager_ID=?";
		try {
			queryRunner.update(sql,manager.getManager_Username(),manager.getManager_Password(),manager.getManager_Name()
       			 ,manager.getManager_Sex(),manager.getManager_Tel(),manager.getManager_ID());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//ɾ��museum
	public void delete(int managerid){
		String sql="delete from manager where Manager_ID=?";
		try {
			queryRunner.update(sql, managerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//��ȡ�б�
	public List<ManagerBean> getList(String strwhere,String strorder){
		String sql="select * from manager";
		if(!isInvalid(strwhere)){
			sql+=" where "+strwhere;
		}
		if(!isInvalid(strorder)){
			sql+=" order by "+strorder;
		}
		try {
			return queryRunner.query(sql,new BeanListHandler<ManagerBean>(ManagerBean.class));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	//��ȡָ��id��bean
	public ManagerBean getBean(int id){
		String sql="select * from manager where Manager_ID=?";
		try {
			return queryRunner.query(sql, new BeanHandler<ManagerBean>(ManagerBean.class),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	//�ж��Ƿ�Ϊ��
	public static boolean isInvalid(String str){
		return (str==null||str.length()==0);
	}
	public static void main(String[] args){
		/*ManagerBean bean = new ManagerDao().getBean(13);
		System.out.println(bean.getManager_Tel());*/
		/*new ManagerDao().getMuseumName("manager1");*/
		
	}
	public String getMuseumName(String username){
		String sql="SELECT Museum_Name FROM museum WHERE Museum_ID= (SELECT mm.MM_MuseumId FROM mm WHERE mm.MM_ManagerId=(SELECT m.Manager_ID FROM manager m WHERE m.Manager_Username='"+username+"'))";
		Connection conn =null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		String museumname=null;
		try {
			conn=JdbcUtil1.getConnection();
			stat= conn.prepareStatement(sql);
			rs= stat.executeQuery();
			while (rs.next()) {
				museumname=rs.getString("Museum_Name");
				//System.out.println(museumname);
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return museumname;
	}
	public void getAllManager(PageBean<ManagerBean> pb, String strwhere,
			String strorder) {
		// TODO Auto-generated method stub
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
				int totalCount = this.getTotalCountManager(strwhere);
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
				String sql="select * from manager";
				
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
					List<ManagerBean> pageData = qr.query(sql, new BeanListHandler<ManagerBean>(ManagerBean.class), index, count);
					// ���õ�pb������
					pb.setPageData(pageData);
					
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
		
	}
	//ͳ����������
		public int getTotalCountManager(String strwhere) {
			String sql = "SELECT COUNT(*) FROM manager";
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
	

}
