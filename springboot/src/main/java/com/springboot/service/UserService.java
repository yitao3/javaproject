package com.springboot.service;
 
import java.util.List;

import com.springboot.bean.User;
 
public interface UserService {
 
	/**
	 * 保存用户对象
	 * @param user
	 */
	void save(User user);

/**
 * 获取所有用户对象
 * @return
 */
List<User> getUserList();
}