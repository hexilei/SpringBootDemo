package com.rmbin.elastic.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import com.rmbin.elastic.model.UserElasModel;
import com.rmbin.elastic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public Long saveUser(UserElasModel user)
	{
		UserElasModel rtUser = userRepo.save(user);
		return rtUser.getId();
	}

	@Override
	public List<UserElasModel> findUsers(Integer pageNum, Integer pageSize, String searchContent) {
		Pageable pageable = new PageRequest(pageNum,pageSize);
		FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("userName", searchContent)),
                    ScoreFunctionBuilders.weightFactorFunction(100));
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
		
		Page<UserElasModel> searchPageResults = userRepo.search(searchQuery);
		return searchPageResults.getContent();
	}

}
