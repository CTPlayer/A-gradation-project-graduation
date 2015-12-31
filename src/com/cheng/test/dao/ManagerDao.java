package com.cheng.test.dao;

import java.util.List;

import com.cheng.test.entity.Announcement;
import com.cheng.test.entity.Bbs;
import com.cheng.test.entity.Blog;
import com.cheng.test.entity.Item;
import com.cheng.test.entity.Lessions;
import com.cheng.test.entity.Paper;
import com.cheng.test.entity.Teacher;
import com.cheng.test.entity.Upload;

public interface ManagerDao {
	public List<Announcement> findAll(final int pageSize,final int pageNo);
	public List<Announcement> findAll();
	public void deleteAnnounce(Announcement announcement);
	public Announcement findById(Integer id);
	public void save(Announcement announcement);
	public List<Teacher> findByEmail(String email);
	public void save(Lessions lessions);
	public List<Lessions> findBySubject(String subject);
	public void save(Upload upload);
	public void deleteLession(Lessions lessions);
	public Lessions findLessionsById(Integer lid);
	public List<Lessions> findAllLessions();
	public void save(Paper paper);
	public void update(Teacher teacher);
	public void save(Item item);
	public Item findByIid(Integer iid);
	public void deleteItem(Item item);
	public Paper findByPid(Integer pid);
	public void deletePaper(Paper paper);
	public List<Bbs> findAllBbs();
	public Bbs findBbsById(Integer bbsid);
	public void deleteBbs(Bbs bbs);
	public void updateBlog(Blog blog);
	public void saveBlog(Blog blog);
}
