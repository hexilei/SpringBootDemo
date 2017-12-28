package com.rmbin.jpa.service;

import java.util.List;

import com.rmbin.jpa.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getUserByUserName(String userName);

}
