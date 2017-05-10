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

import cn.wistron.bean.AlarmBean;
import cn.wistron.bean.MotionBean;
import cn.wistron.bean.SensorBean;
import cn.wistron.utils.JdbcUtil1;
import cn.wistron.utils.JdbcUtils;
import cn.wistron.utils.PageBean;
public class AlarmDao {
	private static QueryRunner queryRunner;
	static{
		queryRunner=JdbcUtils.getQueryRunner();
	}
	//增加报警记录
	public void addAlarm(AlarmBean alarmBean){
		String sql="insert into alarm(Alarm_MuseumName,Alarm_BuildingName,Alarm_StorehouseName,Alarm_SensorId,Alarm_Time,Alarm_Thing,Alarm_Value,Alarm_SensorName) values(?,?,?,?,?,?,?,?)";
		try {
			queryRunner.update(sql,alarmBean.getAlarm_MuseumName(),
					alarmBean.getAlarm_BuildingName(),alarmBean.getAlarm_StorehouseName(),alarmBean.getAlarm_SensorId(),alarmBean.getAlarm_Time(),alarmBean.getAlarm_Thing(),alarmBean.getAlarm_Value(),alarmBean.getAlarm_SensorName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public AlarmBean getFirst(){
		String sql="SELECT * FROM alarm LIMIT 1;";
		try {
			return queryRunner.query(sql, new BeanHandler<AlarmBean>(AlarmBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//删除报警记录
	public void delete(int alarm_id){
		String sql="delete from alarm where Alarm_ID=?";
		try {
			queryRunner.update(sql,alarm_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//获取报警记录
	public List<AlarmBean> getList(String strwhere,String strorder){
		String sql="select * from alarm";
		strwhere="1=1 ";
		if(!isInvalid(strwhere)){
			sql+=" where "+strwhere;
		}
		if(!isInvalid(strorder)){
			sql+=" order by "+strorder;
		}
		try {
			return queryRunner.query(sql, new BeanListHandler<AlarmBean>(AlarmBean.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public AlarmBean getBean(int sensorid){
		String sql="SELECT m.Museum_Name,b.Building_Name,s.Sensor_ID,s.Sensor_ReceiveTime,s.Sensor_Value,s.Sensor_Name FROM museum m,building b,storehouse,sensormanager s WHERE m.Museum_ID=b.Building_MuseumID AND storehouse.Storehouse_BuildingID=b.Building_ID AND s.Sensor_StorehouseID=storehouse.Storehouse_ID AND s.Sensor_ID=?";
		Connection conn =null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		AlarmBean bean = new AlarmBean();
		try {
			conn=JdbcUtil1.getConnection();
			stat= conn.prepareStatement(sql);
			stat.setInt(1, sensorid);
			rs= stat.executeQuery();		
			while(rs.next()){
				bean.setAlarm_BuildingName(rs.getString("Building_Name"));
				bean.setAlarm_StorehouseName(rs.getString("Storehouse_Name"));
				bean.setAlarm_MuseumName(rs.getString("Museum_Name"));
				bean.setAlarm_SensorId(rs.getInt("Sensor_ID"));
				bean.setAlarm_Time(rs.getDate("Sensor_ReceiveTime"));
				bean.setAlarm_Value(rs.getString("Sensor_Value"));
				bean.setAlarm_SensorName(rs.getString("Sensor_Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil1.close(conn, stat, rs);
		}
		return bean;
	}
	public List<AlarmBean> getList(String strwhere){
		String sql="select * from alarm a where a.Alarm_MuseumName=?";
		
		try {
			return queryRunner.query(sql, new BeanListHandler<AlarmBean>(AlarmBean.class),strwhere);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public void getAllAdmin(PageBean<AlarmBean> pb,String strwhere,String strorder) {
		
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount(strwhere);
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
		String sql="select * from alarm";
		
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
			List<AlarmBean> pageData = qr.query(sql, new BeanListHandler<AlarmBean>(AlarmBean.class), index, count);
			// 设置到pb对象中
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public int getTotalCount(String str){
		String sql="select count(*) from alarm ";
		if(!(isInvalid(str)))
		{
			sql+=" where "+str;
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
	public static boolean isInvalid(String str){
		return  (str==null||str.length()==0);
	}
	public static void main(String[] args) {
          /* System.out.println("use for test!");
           AlarmBean bean = new AlarmDao().getBean(4);
           System.out.println(bean.getAlarm_BuildingName()+bean.getAlarm_SensorId());
           new AlarmDao().addAlarm(bean);*/
	/*	System.out.println("begin");
		List<AlarmBean> list = new AlarmDao().getList("孝感市档案局");
		System.out.println("你好");
		*/
	}

}
