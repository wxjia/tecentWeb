package cn.wxjia.pojo;

public class UserInformation {
	private int id;
	private String username;
	private String passwd;
	private String name;

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserInformation(String username, String passwd) {
		super();
		this.username = username;
		this.passwd = passwd;
	}

	public UserInformation(String username, String passwd, String name) {
		super();
		this.username = username;
		this.passwd = passwd;
		this.name = name;
	}

	public UserInformation(int id, String username, String passwd, String name) {
		super();
		this.id = id;
		this.username = username;
		this.passwd = passwd;
		this.name = name;
	}

}
