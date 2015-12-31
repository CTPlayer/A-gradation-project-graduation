package com.cheng.test.dao.daoimpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cheng.test.entity.Bbs;
import com.cheng.test.entity.Blog;
import com.cheng.test.dao.ManagerDao;
import com.cheng.test.entity.Announcement;
import com.cheng.test.entity.Item;
import com.cheng.test.entity.Lessions;
import com.cheng.test.entity.Paper;
import com.cheng.test.entity.Teacher;
import com.cheng.test.entity.Upload;

@Repository
public class ManagerDaoimpl extends HibernateDaoSupport implements ManagerDao {
	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public List<Announcement> findAll(final int pageSize,final int pageNo) {
		List<Announcement> list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Announcement a order by a.id desc";
				List result = session.createQuery(hql).setMaxResults(pageSize).setFirstResult((pageNo-1)*pageSize).list();
				return result;
			}
			
		});
		return list;
	}
	@Override
	public List<Announcement> findAll() {
		String hql = "from Announcement";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public void deleteAnnounce(Announcement announcement) {
		this.getHibernateTemplate().delete(announcement);
	}
	@Override
	public Announcement findById(Integer id) {
		return (Announcement) this.getHibernateTemplate().get("com.cheng.test.entity.Announcement", id);
	}
	@Override
	public void save(Announcement announcement) {
		this.getHibernateTemplate().save(announcement);
	}
	@Override
	public List<Teacher> findByEmail(String email) {
		String hql = "from Teacher t where t.email = ?";
		List<Teacher> teachers = this.getHibernateTemplate().find(hql,email);
		return teachers;
	}
	@Override
	public void save(Lessions lessions) {
		this.getHibernateTemplate().save(lessions);
	}
	@Override
	public List<Lessions> findBySubject(String subject) {
		String hql = "from Lessions l where l.subject = ?";
		List<Lessions> lessions = this.getHibernateTemplate().find(hql,subject);
		return lessions;
	}
	@Override
	public void save(Upload upload) {
		this.getHibernateTemplate().save(upload);
	}
	@Override
	public void deleteLession(Lessions lessions) {
		this.getHibernateTemplate().delete(lessions);
	}
	@Override
	public Lessions findLessionsById(Integer lid) {
		return (Lessions) this.getHibernateTemplate().get("com.cheng.test.entity.Lessions", lid);
	}
	@Override
	public List<Lessions> findAllLessions() {
		String hql = "from Lessions";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public void save(Paper paper) {
		this.getHibernateTemplate().save(paper);
	}
	@Override
	public void update(Teacher teacher) {
		this.getHibernateTemplate().update("com.cheng.test.entity.Teacher", teacher);
	}
	@Override
	public void save(Item item) {
		this.getHibernateTemplate().save(item);
	}
	@Override
	public Item findByIid(Integer iid) {
		return (Item) this.getHibernateTemplate().get("com.cheng.test.entity.Item", iid);
	}
	@Override
	public void deleteItem(Item item) {
		this.getHibernateTemplate().delete(item);
	}
	@Override
	public Paper findByPid(Integer pid) {
		return (Paper) this.getHibernateTemplate().get("com.cheng.test.entity.Paper", pid);
	}
	@Override
	public void deletePaper(Paper paper) {
		this.getHibernateTemplate().delete(paper);
	}
	@Override
	public List<Bbs> findAllBbs() {
		String hql = "from Bbs";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public Bbs findBbsById(Integer bbsid) {
		return (Bbs) this.getHibernateTemplate().get("com.cheng.test.entity.Bbs", bbsid);
	}
	@Override
	public void deleteBbs(Bbs bbs) {
		this.getHibernateTemplate().delete(bbs);
	}
	@Override
	public void updateBlog(Blog blog) {
		this.getHibernateTemplate().update("com.cheng.test.entity.Blog", blog);
	}
	@Override
	public void saveBlog(Blog blog) {
		this.getHibernateTemplate().save(blog);
	}
}
