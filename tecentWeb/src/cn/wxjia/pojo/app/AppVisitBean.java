package cn.wxjia.pojo.app;

import java.util.Date;

public class AppVisitBean {
	private int id;
	private String teleNumber;
	private Date visitTime;
	private String ip;
	private String address;
	private String mType;
	private int mWide;
	private int mHeight;
	private String imei;
	private String macAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeleNumber() {
		return teleNumber;
	}

	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
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

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public int getmWide() {
		return mWide;
	}

	public void setmWide(int mWide) {
		this.mWide = mWide;
	}

	public int getmHeight() {
		return mHeight;
	}

	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public AppVisitBean(int id, String teleNumber, Date visitTime, String ip,
			String address, String mType, int mWide, int mHeight, String imei,
			String macAddress) {
		super();
		this.id = id;
		this.teleNumber = teleNumber;
		this.visitTime = visitTime;
		this.ip = ip;
		this.address = address;
		this.mType = mType;
		this.mWide = mWide;
		this.mHeight = mHeight;
		this.imei = imei;
		this.macAddress = macAddress;
	}

}
