package cn.wxjia.pojo;

import java.util.Date;

public class LoginRecordBean {

	private int id;
	private String username;
	private Date loginTime;
	private String ip;
	private String address;

	public LoginRecordBean(int id, String username, Date loginTime, String ip,
			String address) {
		super();
		this.id = id;
		this.username = username;
		this.loginTime = loginTime;
		this.ip = ip;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
