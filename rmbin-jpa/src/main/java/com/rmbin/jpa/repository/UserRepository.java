package com.rmbin.jpa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.rmbin.model.UserModel;

@Mapper
public interface UserRepository {
	
	@Select("SELECT userId, userName, sexy, email, createDate from user")
	public List<UserModel> getAllUsers();
	
	@Select("SELECT userId,userName,sexy,email,createDate from user where userName=?")
	public UserModel getUserByUserName(String userName);

}
