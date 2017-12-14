package com.rmbin.jpa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository<UserModel> {
	
	@Select("SELECT userId, userName, sexy, email, createDate from user")
	public List<UserModel> getAllUsers();
	
	@Select("SELECT userId,userName,sexy,email,createDate from user where userName=?")
	public UserModel getUserByUserName(String userName);

}
