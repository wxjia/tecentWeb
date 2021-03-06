package cn.wxjia.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.wxjia.dao.ConnectDataBase;
import cn.wxjia.pojo.LoginRecordBean;

public class LoginRecordDao {
	public boolean insertLoginRecord(LoginRecordBean loginRecord) {

		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == loginRecord) {
			System.out.println("null == connection || null == loginRecord");
			return false;
		}
		String sql = "insert into loginRecord(username,loginTime,ip,address) values(?,NOW(),?,?)";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, loginRecord.getUsername());
			preparedStatement.setString(2, loginRecord.getIp());
			preparedStatement.setString(3, loginRecord.getAddress());

			int num = preparedStatement.executeUpdate();
			if (num > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return false;
	}

}
