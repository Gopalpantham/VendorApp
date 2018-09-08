package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tab")
public class User {
	@Id
	@GeneratedValue
	private int uid;
	private String userName;
	private String email;
	private String mobile;
	private String pwd;
	private String addr;
	public User(int uid) {
		super();
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", email="
				+ email + ", mobile=" + mobile + ", pwd=" + pwd + ", addr="
				+ addr + "]";
	}
	public User() {
		super();
	}
	

}
