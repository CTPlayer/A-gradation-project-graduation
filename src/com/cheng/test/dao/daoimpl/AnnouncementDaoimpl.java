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

import com.cheng.test.dao.AnnouncementDao;
import com.cheng.test.entity.Announcement;
import com.cheng.test.entity.Answer;
import com.cheng.test.entity.Bbs;
@Repository
public class AnnouncementDaoimpl extends HibernateDaoSupport implements AnnouncementDao {
	
	@Resource(name="sessionFactory")
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
				List result = session.createQuery(hql).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
				return result;
			}			
		});
		return list;
	}

	@Override
	public List<Announcement> findLimt_3() {
		String hql = "from Announcement a order by a.id desc";
		List<Announcement> announcement = this.getHibernateTemplate().find(hql).subList(0, 3);
		return announcement;
	}

	@Override
	public Integer findAmount() {
		String hql = "from Announcement";
		List<Announcement> announcement = this.getHibernateTemplate().find(hql);
		return announcement.size();
	}

	@Override
	public List<Bbs> findAll() {
		String hql = "from Bbs";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<Bbs> findByBbsid(Integer bbsid) {
		String hql = "from Bbs b where b.bbsid = ?";
		return this.getHibernateTemplate().find(hql,bbsid);
	}

	@Override
	public void AddBbs(Bbs bbs) {
		this.getHibernateTemplate().save(bbs);
	}

	@Override
	public void AddAnswer(Answer answer) {
		this.getHibernateTemplate().save(answer);
	}

	@Override
	public List<Answer> findAllAnswerBybbsid(Integer bbsid) {
		String hql = "from Answer where bbsid = ?";
		return this.getHibernateTemplate().find(hql,bbsid);
	}

	@Override
	public List<Bbs> findAllBbs(final int pageSize,final int pageNo) {
		List<Bbs> list = getHibernateTemplate().executeFind(new  HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "from Bbs b order by b.bbsid desc";
				List result = session.createQuery(hql).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
				return result;
			}
			
		});
		return list;
	}

}
