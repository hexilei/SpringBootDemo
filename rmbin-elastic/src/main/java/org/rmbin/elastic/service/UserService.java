package org.rmbin.elastic.service;

import java.util.List;

import org.rmbin.elastic.model.UserElasModel;

public interface UserService {
	
	public List<UserElasModel> findUsers(Integer pageNum, Integer pageSize, String searchContent);

}
