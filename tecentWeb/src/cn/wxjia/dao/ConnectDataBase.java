package cn.wxjia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库
 * 
 * @author Jia_Vc
 * 
 */
public class ConnectDataBase {
	/**
	 * 返回一个数据库连接对象
	 * 
	 * @return
	 */
	public static Connection getConnectionByJdbc() {
		Connection conn = null;

		// 默认公网
		String username = "root";
		String passwd = "jwx1016";
		String port = "3306";
		String dateBaseName = "test";
		String url = "119.29.223.93";

		String os = System.getProperty("os.name");
		String osUser = System.getProperty("user.name");
		// 如果是内网
		if ("Linux".equals(os) && "ubunru".equals(osUser)) {
			url = "127.0.0.1";
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String connStr = "jdbc:mysql://" + url + ":" + port + "/"
					+ dateBaseName + "?characterEncoding=UTF-8";
			conn = DriverManager.getConnection(connStr, username, passwd);
		} catch (ClassNotFoundException e) {
			System.out.println("可能是jar包没导入");
			System.out.println("ClassNotFoundException" + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("SQLException " + e.getMessage());
			return null;
		}
		System.out.println("数据库连接成功");
		return conn;
	}
}
