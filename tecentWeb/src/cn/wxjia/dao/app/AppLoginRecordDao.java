package cn.wxjia.dao.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.wxjia.dao.ConnectDataBase;
import cn.wxjia.pojo.app.AppLoginRecordBean;

public class AppLoginRecordDao {

	public boolean insertAppVisiterData(AppLoginRecordBean bean) {
		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == bean) {
			System.out.println("null == connection || null == newVisiterBean");
			System.out.println("数据库连接失败");
			return false;
		}
		String sql = "insert into appLoginRecord(username,loginTime,ip,address,teleNumber,providersName,screen,apps,contacts,direction,voice,light) values(?,NOW(),?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, bean.getUsername());
			preparedStatement.setString(2, bean.getIp());
			preparedStatement.setString(3, bean.getAddress());
			preparedStatement.setString(4, bean.getTeleNumber());
			preparedStatement.setString(5, bean.getProvidersName());
			preparedStatement.setString(6, bean.getScreen());
			preparedStatement.setString(7, bean.getApps());
			preparedStatement.setString(8, bean.getContacts());
			preparedStatement.setString(9, bean.getDirection());
			preparedStatement.setString(10, bean.getVoice());
			preparedStatement.setString(11, bean.getLight());

			System.out.println("bean.getProvidersName() = "
					+ bean.getProvidersName());
			System.out.println(" bean.getApps() = " + bean.getApps());
			System.out.println("bean.getContacts()" + bean.getContacts());

			int updateNumber = preparedStatement.executeUpdate();
			System.out.println("updateNumber = " + updateNumber);
		} catch (SQLException e) {
			System.out.println("操作数据库时出现异常 " + e.getMessage());
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("关闭connection连接时出现异常 " + e.getMessage());
				return false;
			}
		}
		return true;
	}
}
