package com.cheng.test.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.test.dao.UserDao;
import com.cheng.test.entity.Teacher;
import com.cheng.test.entity.User;
import com.cheng.test.service.Userservice;

@Service
public class Userserviceimpl implements Userservice{

	@Autowired
	private UserDao userDao;
	@Override
	public boolean checkLogin(String userName, String userPassword) {
		List<User> list = userDao.findByNameAndPassword(userName, userPassword);
		List<Teacher> list2 = userDao.findByEmail(userName);
		if(list.size()>0||list2.size()>0){
			return true;
		}else{
		return false;
		}
	}
	@Override
	public boolean teacherCheckLogin(String email, String Password) {
		System.out.println(email+Password);
		List<Teacher> list = userDao.findTeacherByNameAndPassword(email, Password);
		if(list.size()>0){
			return true;
		}else{
		return false;
		}
	}

}
