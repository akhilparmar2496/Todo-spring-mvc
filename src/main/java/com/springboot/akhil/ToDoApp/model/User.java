package com.springboot.akhil.ToDoApp.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
//	public void User(){
//		
//	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
