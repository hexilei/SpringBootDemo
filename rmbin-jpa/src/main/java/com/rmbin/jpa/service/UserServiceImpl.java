package com.rmbin.jpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rmbin.jpa.entity.User;
import com.rmbin.jpa.repository.UserRepository;


@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User getUserByUserName(String userName)
	{
		return userRepository.getUserByUserName(userName);
	}

}
