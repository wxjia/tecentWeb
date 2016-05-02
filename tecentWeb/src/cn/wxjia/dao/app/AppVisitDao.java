package cn.wxjia.dao.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.wxjia.dao.ConnectDataBase;
import cn.wxjia.pojo.app.AppVisitBean;

public class AppVisitDao {

	public List<AppVisitBean> getAppVisit() {
		Connection connection = ConnectDataBase.getConnectionByJdbc();

		List<AppVisitBean> list = new ArrayList<>();

		if (null == connection) {
			System.out.println("null == connection");
			System.out.println("数据库连接失败");
			return null;
		}
		String sql = "SELECT teleNumber,visitTime,ip,address,mType,mWidth,mHeight,imei,macAddress FROM appVisit ORDER BY visitTime DESC";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String teleNumber = resultSet.getString("teleNumber");
				Date date = (Date) resultSet.getTimestamp("visitTime");
				String ip = resultSet.getString("ip");
				String address = resultSet.getString("address");
				String mType = resultSet.getString("mType");
				int mWidth = resultSet.getInt("mWidth");
				int mHeight = resultSet.getInt("mHeight");
				String imei = resultSet.getString("imei");
				String macAddress = resultSet.getString("macAddress");

				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String dateAndTime = dateFormat.format(date);

				AppVisitBean bean = new AppVisitBean(0, teleNumber,
						dateAndTime, ip, address, mType, mWidth, mHeight, imei,
						macAddress);
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

	public void insertAppVisiterData(AppVisitBean bean) {
		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == bean) {
			System.out.println("null == connection || null == newVisiterBean");
			System.out.println("数据库连接失败");
			return;
		}
		String sql = "insert into appVisit(teleNumber,visitTime,ip,address,mType,mWidth,mHeight,imei,macAddress) values(?,NOW(),?,?,?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, bean.getTeleNumber());
			preparedStatement.setString(2, bean.getIp());
			preparedStatement.setString(3, bean.getAddress());
			preparedStatement.setString(4, bean.getmType());
			preparedStatement.setInt(5, bean.getmWidth());
			preparedStatement.setInt(6, bean.getmHeight());
			preparedStatement.setString(7, bean.getImei());
			preparedStatement.setString(8, bean.getMacAddress());

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
