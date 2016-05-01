package cn.wxjia.pojo;

public class WebVisitBean {
	private int id;
	private String ip;
	private String visitTime;
	private String address;
	private String userAgent;

	public WebVisitBean(int id, String ip, String visitTime, String address,
			String userAgent) {
		super();
		this.id = id;
		this.ip = ip;
		this.visitTime = visitTime;
		this.address = address;
		this.userAgent = userAgent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

}
