package com.circle.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.circle.dao.AbstractDao;
import com.circle.dao.UserDao;
import com.circle.model.User;

@Repository("UserDao")
public class UserDaoImpl  extends AbstractDao<Long, User> implements UserDao{

	
	 @Autowired
	    private SessionFactory sessionFactory;
	 protected Session getSession(){
	        return sessionFactory.getCurrentSession();
	    }
	 
	 
	@Override
	public User findById(long id) {
		return getByKey(id);
	}

	@Override
	public User findByName(String name) {
	Query query = getSession().createQuery("from User where username=:username");
	query.setString("username",name);
		return (User) query.uniqueResult();
	}

	@Override
	public void saveUser(User user) {
		persist(user);
		
	}

	@Override
	public void updateUser(User user) {
		update(user);
		
	}

	@Override
	public void deleteUserById(long id) {
		delete(id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		 Criteria criteria = createEntityCriteria();
	        return (List<User>) criteria.list();
	}

	@Override
	public void deleteAllUsers() {
		deleteAllUsers();
		
	}

	@Override
	public boolean isUserExist(User user) {
		List<User> list = new ArrayList<>();
	list= get(user);
	 
return list.isEmpty();
	}

}
