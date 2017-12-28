package com.rmbin.dao;

import java.util.List;
import com.rmbin.model.UserModel;

public interface UserDao {
	
	public UserModel findByUserId(UserModel userModel);
	
	public List<UserModel> findUsers(UserModel userModel);
	
	public boolean addUserModel(UserModel userModel);
	
	public boolean updateUserModel(UserModel userModel);
	
	public boolean deleteUses(UserModel userModel);
	
	public boolean deleteUser(UserModel userModel);

}
