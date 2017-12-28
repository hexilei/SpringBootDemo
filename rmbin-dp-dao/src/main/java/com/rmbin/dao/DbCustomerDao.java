package com.rmbin.dao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;
import com.rmbin.model.UserModel;

public class DbCustomerDao implements UserDao {
	
	private DataSource dataSource;
	
	private Connection  getConnection() throws DaoException
	{
		try
		{
			return dataSource.getConnection();
		}
		catch(Exception ex)
		{
			throw new DaoException(ex.getMessage());
		}
	}

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
