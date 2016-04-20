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
		try {
			String username = "cdb_outerroot";
			String passwd = "wxjia1234";
			String url = "5712e4b241029.gz.cdb.myqcloud.com";
			String port = "11907";
			String dateBaseName = "test";
			Class.forName("com.mysql.jdbc.Driver");

			String connStr = "jdbc:mysql://" + url + ":" + port + "/"
					+ dateBaseName + "?characterEncoding=UTF-8";
			// System.out.println("connStr " + connStr);
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
