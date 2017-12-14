package com.rmbin.elastic.service;

import java.util.List;

import com.rmbin.elastic.model.UserElasModel;

public interface UserService {
	
	public List<UserElasModel> findUsers(Integer pageNum, Integer pageSize, String searchContent);

}
