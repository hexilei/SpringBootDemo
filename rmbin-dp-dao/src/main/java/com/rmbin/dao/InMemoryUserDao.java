package com.rmbin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rmbin.model.UserModel;

public class InMemoryUserDao implements UserDao {
	
	private Map<String, UserModel> users = new HashMap<String,UserModel>();

	@Override
	public UserModel findByUserId(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findUsers(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUserModel(UserModel userModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserModel(UserModel userModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUses(UserModel userModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(UserModel userModel) {
		// TODO Auto-generated method stub
		return false;
	}

}
