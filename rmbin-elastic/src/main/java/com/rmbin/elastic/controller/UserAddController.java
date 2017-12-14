package com.rmbin.elastic.controller;

import java.util.List;
import com.rmbin.elastic.model.UserElasModel;
import com.rmbin.elastic.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rmbin.model.UserModel;

@RestController
@RequestMapping(value="/elastic/user")
public class UserAddController {
	
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value="/add",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
	public UserModel addUser()
	{
		UserElasModel user = new UserElasModel("firstUserInElastic", "Louis");
		userService.saveUser(user);
		return user;
	}
	
	@RequestMapping(value="/getUsers/{num}/{size}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public List<UserElasModel> getUsers(@RequestParam("content") String content,@PathVariable("num") int num, @PathVariable("size") int size)
	{
		return userService.findUsers(num, size, content);
	}
}
