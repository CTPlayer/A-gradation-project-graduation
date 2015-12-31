package com.cheng.test.dao;

import java.util.List;

import com.cheng.test.entity.Announcement;
import com.cheng.test.entity.Answer;
import com.cheng.test.entity.Bbs;

public interface AnnouncementDao {
	public List<Announcement> findAll(int pageSize,int pageNo);
	public List<Bbs> findAllBbs(int pageSize,int pageNo);
	public List<Announcement> findLimt_3();
	public Integer findAmount();
	
	public List<Bbs> findAll();
	public List<Bbs> findByBbsid(Integer bbsid);
	public void AddBbs(Bbs bbs);
	public void AddAnswer(Answer answer);
	public List<Answer> findAllAnswerBybbsid(Integer bbsid);
}
