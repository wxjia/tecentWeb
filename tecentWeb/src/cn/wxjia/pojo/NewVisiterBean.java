package cn.wxjia.pojo;

public class NewVisiterBean {
	private int id;
	private String ip;
	private String visitTime;
	private String address;
	private String userAgent;

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

	public NewVisiterBean(String ip, String address) {
		super();
		this.ip = ip;
		this.address = address;
	}

	public NewVisiterBean(String ip, String visitTime, String address,
			String userAgent) {
		super();
		this.ip = ip;
		this.visitTime = visitTime;
		this.address = address;
		this.userAgent = userAgent;
	}

	public NewVisiterBean(int id, String ip, String visitTime, String address) {
		super();
		this.id = id;
		this.ip = ip;
		this.visitTime = visitTime;
		this.address = address;
	}

}
