package com.circle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circle.dao.UserDao;
import com.circle.model.User;
import com.circle.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	
	public User findById(long id) {
		
		return userDao.findById(id);
	}
	
	public User findByName(String userName) {
		return userDao.findByName(userName);
	}
	
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUserById(long id) {
		
	userDao.deleteUserById(id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		userDao.deleteAllUsers();
	}

	 
}
