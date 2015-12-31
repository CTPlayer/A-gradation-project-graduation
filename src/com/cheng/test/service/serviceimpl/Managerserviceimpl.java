package com.cheng.test.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.test.dao.ManagerDao;
import com.cheng.test.service.Managerservice;

@Service
public class Managerserviceimpl implements Managerservice {
	
	@Autowired
	private ManagerDao managerdao;

	@Override
	public Integer getTotalPages() {
		Integer totalPages;
		Integer totalNumber = managerdao.findAll().size();
		if(totalNumber%8==0){
			totalPages = totalNumber/8;
		}else{
			totalPages = totalNumber/8+1;
		}
		return totalPages;
	}

}
