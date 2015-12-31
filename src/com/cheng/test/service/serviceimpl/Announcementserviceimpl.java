package com.cheng.test.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.test.dao.AnnouncementDao;
import com.cheng.test.dao.UserDao;
import com.cheng.test.service.Announcementservice;

@Service
public class Announcementserviceimpl implements Announcementservice {
	
	@Autowired
	private UserDao Userdao;

	@Override
	public Integer getTotalPages() {
		Integer totalPages;
		Integer totalNumber = Userdao.findAll().size();
		if(totalNumber%10==0){
			totalPages = totalNumber/10;
		}else{
			totalPages = totalNumber/10+1;
		}
		return totalPages;
	}

}
