package cn.wxjia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.wxjia.pojo.WebVisitBean;

public class VisiterDao {

	public List<WebVisitBean> getVisiterData() {
		Connection connection = ConnectDataBase.getConnectionByJdbc();

		List<WebVisitBean> list = new ArrayList<>();

		if (null == connection) {
			System.out.println("null == connection || null == newVisiterBean");
			System.out.println("数据库连接失败");
			return null;
		}
		String sql = "SELECT ip,visitTime,address,userAgent FROM webVisit ORDER BY visitTime DESC";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String ip = resultSet.getString("ip");
				Date date = (Date) resultSet.getTimestamp("visitTime");
				String address = resultSet.getString("address");
				String userAgent = resultSet.getString("userAgent");

				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String dateAndTime = dateFormat.format(date);

				WebVisitBean bean = new WebVisitBean(0, ip, dateAndTime,
						address, userAgent);
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("操作数据库时出现异常 " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("关闭connection连接时出现异常 " + e.getMessage());
			}
		}
		return list;
	}

	public void insertNewVisiterData(WebVisitBean newVisiterBean) {
		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == newVisiterBean) {
			System.out.println("null == connection || null == newVisiterBean");
			System.out.println("数据库连接失败");
			return;
		}
		String sql = "insert into webVisit(ip,visitTime,address,userAgent) values(?,NOW(),?,?);";
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
