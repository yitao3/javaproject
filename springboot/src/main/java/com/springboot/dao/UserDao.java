package com.springboot.dao;
 
import org.springframework.stereotype.Repository;
 
import com.springboot.bean.User;
 
@Repository
public interface UserDao extends CommonDao<User> {
 
}