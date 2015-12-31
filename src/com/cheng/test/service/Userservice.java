package com.cheng.test.service;

public interface Userservice {
	public boolean checkLogin(String userName,String userPassword);
	public boolean teacherCheckLogin(String email,String Password);
}
