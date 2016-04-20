package cn.wxjia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.wxjia.pojo.LeaveWordBean;

public class LeaveWordDao {
	
	public boolean insertLeaveWord(LeaveWordBean leaveWordBean){
		Connection connection = ConnectDataBase.getConnectionByJdbc();
		if (null == connection || null == leaveWordBean) {
			System.out.println("null == connection || null == leaveWordBean");
			return false;
		}
		String sql = "insert into leaveWord(username,wordTime,word) values(?,NOW(),?)";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, leaveWordBean.getUsername());
			preparedStatement.setString(2, leaveWordBean.getWord());
			
			System.out.println("leaveWordBean.getUsername()"+leaveWordBean.getUsername());
			System.out.println("leaveWordBean.getWord()"+leaveWordBean.getWord());

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
