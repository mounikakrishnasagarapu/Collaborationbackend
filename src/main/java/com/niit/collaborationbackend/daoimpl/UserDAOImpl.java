package com.niit.collaborationbackend.daoimpl;

import java.util.List;



import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	
	
	@Autowired
	public SessionFactory sessionfactory;

	
	public UserDAOImpl(SessionFactory sessionfactory){

		this.sessionfactory = sessionfactory;
	}
    @Transactional 
	public List<User> list() {
		String hql ="from User";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
    @Transactional 
	public boolean saveOrUpdate(User user) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} 
		catch (Exception e) {
			
		e.printStackTrace();
		}
		return false;
	}
    @Transactional 
	public User get(int id) {
		
		User user=(User) sessionfactory.getCurrentSession().get(User.class,id);
		return user;
	}
    @Transactional 
	public User validate(int id, String password) {
		String hql ="From user where id ='" + id +" ' and password =' "+password+" ' ";
		@SuppressWarnings("rawtypes")
		org.hibernate.Query query = null;
		@SuppressWarnings({ "null", "deprecation", "unused" })
		User user = (User) query.uniqueResult();
		return null;
	}
	public User profileof(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public User oneuser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<User> nonfriends(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
	public User authuser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<User> getuser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}