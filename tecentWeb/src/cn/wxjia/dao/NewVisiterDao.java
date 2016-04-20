package cn.wxjia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.wxjia.pojo.NewVisiterBean;

public class NewVisiterDao {
	public void insertNewVisiterData(NewVisiterBean newVisiterBean) {
		Connection connection = ConnectDataBase.getConnectionByJdbc();

		if (null == connection || null == newVisiterBean) {
			System.out.println("null == connection || null == newVisiterBean");
			System.out.println("数据库连接失败");
			return;
		}
		String sql = "insert into visitTest(ip,visitTime,address,userAgent) values(?,NOW(),?,?);";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, newVisiterBean.getIp());

			String address = newVisiterBean.getAddress();
			preparedStatement.setString(2, address);
			preparedStatement.setString(3, newVisiterBean.getUserAgent());
			int updateNumber = preparedStatement.executeUpdate();
			System.out.println("updateNumber = " + updateNumber);
		} catch (SQLException e) {
			System.out.println("操作数据库时出现异常 " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("关闭connection连接时出现异常 " + e.getMessage());
			}
		}
	}
}
