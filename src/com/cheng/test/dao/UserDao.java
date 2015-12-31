package com.cheng.test.dao;

import java.util.List;

import com.cheng.test.entity.Teacher;
import com.cheng.test.entity.User;

public interface UserDao {
	public List findByNameAndPassword(String userName,String userPassword);
	public List findTeacherByNameAndPassword(String email,String Password);
	public List<User> findByUsername(String username);
	
	public List<Teacher> findByInstitute(String institute);
	public List<Teacher> findByTeachername(String teachername);
	public List<Teacher> findByInstituteHaveResource(String institute);
	public List<Teacher> findAll(Integer pageSize,Integer pageNo);
	public List<Teacher> findAll();
	public List<Teacher> findByEmail(String email);
}
