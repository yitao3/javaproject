package com.springboot.bean;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name = "user")
public class User extends BaseBean {
 
	@Column(name="user_name")
	public String name;
	@Column(name="user_password")
	public String password;

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
}