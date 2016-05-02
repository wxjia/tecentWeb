package cn.wxjia.pojo.app;

public class AppVisitBean {
	private int id;
	private String teleNumber;
	private String visitTime;
	private String ip;
	private String address;
	private String mType;
	private int mWidth;
	private int mHeight;
	private String imei;
	private String macAddress;

	public AppVisitBean(int id, String teleNumber, String visitTime, String ip,
			String address, String mType, int mWidth, int mHeight, String imei,
			String macAddress) {
		super();
		this.id = id;
		this.teleNumber = teleNumber;
		this.visitTime = visitTime;
		this.ip = ip;
		this.address = address;
		this.mType = mType;
		this.mWidth = mWidth;
		this.mHeight = mHeight;
		this.imei = imei;
		this.macAddress = macAddress;
	}

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

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
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

	public int getmWidth() {
		return mWidth;
	}

	public void setmWidth(int mWidth) {
		this.mWidth = mWidth;
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

}
