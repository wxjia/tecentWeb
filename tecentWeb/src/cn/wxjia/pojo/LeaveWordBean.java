package cn.wxjia.pojo;

import java.util.Date;

public class LeaveWordBean {
	private int id;
	private String username;
	private Date wordTime;
	private String word;

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

	public Date getWordTime() {
		return wordTime;
	}

	public void setWordTime(Date wordTime) {
		this.wordTime = wordTime;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public LeaveWordBean(String username, Date wordTime, String word) {
		super();
		this.username = username;
		this.wordTime = wordTime;
		this.word = word;
	}

}
