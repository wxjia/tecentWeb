package cn.wxjia.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wxjia.dao.ConnectDataBase;
import cn.wxjia.pojo.UserInformation;

public class UserDao {

	/**
	 * 根据用户名判断用户是否存在
	 * 
	 * @param uasename
	 * @return
	 */
	public boolean isExist(String username) {
		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == username) {
			System.out.println("null == connection || null == username");
			return false;
		}
		String sql = "SELECT id FROM userInformation WHERE username=?";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return false;
	}

	/**
	 * 注册时插入用户
	 * 
	 * @return
	 */
	public boolean insertUser(UserInformation information) {
		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == information) {
			System.out.println("null == connection || null == information");
			return false;
		}
		String sql = "insert into userInformation(username,password,name) values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, information.getUsername());
			preparedStatement.setString(2, information.getPasswd());
			preparedStatement.setString(3, information.getName());

			int num = preparedStatement.executeUpdate();
			if (num > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return false;
	}

	/**
	 * 登录验证
	 * 
	 * @return
	 */
	public boolean check(String username, String password) {
		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == username || null == password) {
			System.out
					.println("null == connection || null == username || null == password");
			return false;
		}
		String sql = "SELECT id FROM userInformation WHERE username=? and password=?";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return false;
	}
}
