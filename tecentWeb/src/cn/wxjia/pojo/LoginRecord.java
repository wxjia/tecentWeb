package cn.wxjia.pojo;

import java.util.Date;

public class LoginRecord {
	private String username;
	private Date loginTime;
	private String ip;
	private String address;
	private String browser;
	private String os;

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

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public LoginRecord(String username, Date loginTime, String ip,
			String address, String browser, String os) {
		super();
		this.username = username;
		this.loginTime = loginTime;
		this.ip = ip;
		this.address = address;
		this.browser = browser;
		this.os = os;
	}

}
