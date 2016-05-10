package cn.wxjia.pojo.app;

import java.util.Date;

public class AppLoginRecordBean {

	private int id;
	private String username;
	private Date loginTime;
	private String ip;
	private String address;
	private String teleNumber;
	private String providersName;
	private String screen;
	private String apps;
	private String contacts;
	private String direction;
	private String voice;
	private String light;

	public AppLoginRecordBean(int id, String username, Date loginTime,
			String ip, String address, String teleNumber, String providersName,
			String screen, String apps, String contacts, String direction,
			String voice, String light) {
		super();
		this.id = id;
		this.username = username;
		this.loginTime = loginTime;
		this.ip = ip;
		this.address = address;
		this.teleNumber = teleNumber;
		this.providersName = providersName;
		this.screen = screen;
		this.apps = apps;
		this.contacts = contacts;
		this.direction = direction;
		this.voice = voice;
		this.light = light;
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

	public String getTeleNumber() {
		return teleNumber;
	}

	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

	public String getProvidersName() {
		return providersName;
	}

	public void setProvidersName(String providersName) {
		this.providersName = providersName;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getApps() {
		return apps;
	}

	public void setApps(String apps) {
		this.apps = apps;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

}