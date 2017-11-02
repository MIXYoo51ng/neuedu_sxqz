package com.neuedu.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 5957171122457767345L;
	
	private Integer id;
	private String username;
	private String password;
	private String realname;
	private String sex;
	private String headimgpath;
	
	public User() {
		super();
	}
	
	public User(Integer id, String username, String password, String realname, String sex, String headimgpath) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.headimgpath = headimgpath;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadimgpath() {
		return headimgpath;
	}
	public void setHeadimgpath(String headimgpath) {
		this.headimgpath = headimgpath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
