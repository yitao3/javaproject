package com.springboot.service.impl;
 
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.springboot.bean.User;
import com.springboot.service.UserService;
import com.springboot.dao.*; 

@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserDao userDao;
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

@Override
public List<User> getUserList() {
    return userDao.findAll();
} 
}