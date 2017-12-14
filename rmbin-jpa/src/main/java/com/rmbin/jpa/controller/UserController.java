package com.rmbin.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmbin.jpa.service.UserService;
import com.rmbin.model.UserModel;

@RestController
@RequestMapping(value="/jpa/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/getUsers",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
	public List<UserModel> listUsers()
	{
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/getUserByName",method=RequestMethod.GET,produces={"application/xml;charset=UTF-8"})
	public UserModel getUserByUserName(String userName)
	{
		return userService.getUserByUserName(userName);
	}
	
}
