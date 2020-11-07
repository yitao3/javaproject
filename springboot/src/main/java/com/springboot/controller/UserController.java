package com.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import com.springboot.service.UserService;
import com.springboot.bean.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService; 
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello WorldEDF !!!";
	}
@RequestMapping("/index")
public String index(Model model) {
	model.addAttribute("name", "jack");
	model.addAttribute("age", 20);
	model.addAttribute("info", "我是一个爱学习的好青年");
	return "index";
}

@RequestMapping("/save")
@ResponseBody
public String save(User user) {
	userService.save(user);
	return "save success !";
}

@RequestMapping("/userList")
public String userList(Model model) {
    List<User> userList = userService.getUserList();
    model.addAttribute("userList", userList);
    return "list";
}
}
