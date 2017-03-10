package com.fit.bean;

public class Users {

	private String u_id;
	private String u_pwd;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String u_id, String u_pwd) {
		super();
		this.u_id = u_id;
		this.u_pwd = u_pwd;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", u_pwd=" + u_pwd + "]";
	}
	
	
	
}
