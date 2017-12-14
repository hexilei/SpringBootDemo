package com.rmbin.jpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rmbin.model.UserModel;

import com.rmbin.jpa.repository.UserRepository;

@Service("userService")
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public List<UserModel> getAllUsers()
	{
		return userRepository.getAllUsers();
	}
	
	public UserModel getUserByUserName(String userName)
	{
		return userRepository.getUserByUserName(userName);
	}

}
