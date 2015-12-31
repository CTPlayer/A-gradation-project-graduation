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

import com.cheng.test.dao.UserDao;
import com.cheng.test.entity.Teacher;
import com.cheng.test.entity.User;

@Repository
public class UserDaoimpl extends HibernateDaoSupport implements UserDao{

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public List findByNameAndPassword(String userName, String userPassword) {
		String hql = "from User u where u.username= ? and u.password = ?";
		Object[] value = {userName,userPassword};
		List<User> list = this.getHibernateTemplate().find(hql,value);
		return list;
	}
	@Override
	public List<Teacher> findByInstitute(String institute) {
		String hql = "from Teacher t where t.institute = ?";
		List<Teacher> list = this.getHibernateTemplate().find(hql, institute);
		return list;
	}
	@Override
	public List<Teacher> findByTeachername(String teachername) {
		String hql = "from Teacher t where t.username = ?";
		List<Teacher> teacher = this.getHibernateTemplate().find(hql,teachername);
		return teacher;
	}
	@Override
	public List<Teacher> findByInstituteHaveResource(String institute) {
		String hql = "from Teacher t where t.institute = ? and t.resource = ?";
		List<Teacher> teacher = this.getHibernateTemplate().find(hql,institute,"true");
		return teacher;
	}
	@Override
	public List<Teacher> findAll(final Integer pageSize,final Integer pageNo) {
		List<Teacher> list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Teacher";
				List result = session.createQuery(hql).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
				return result;
			}			
		});
		return list;
	}
	@Override
	public List<Teacher> findAll() {
		String hql = "from Teacher";		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List findTeacherByNameAndPassword(String email, String Password) {
		String hql = "from Teacher t where t.email= ? and t.password = ?";
		List<Teacher> list = this.getHibernateTemplate().find(hql,email,Password);
		return list;
	}
	@Override
	public List<Teacher> findByEmail(String email) {
		String hql = "From Teacher t where t.email = ?";
		return this.getHibernateTemplate().find(hql,email);
	}
	@Override
	public List<User> findByUsername(String username) {
		String hql = "from User u where u.username = ?";
		return this.getHibernateTemplate().find(hql,username);
	}

}
