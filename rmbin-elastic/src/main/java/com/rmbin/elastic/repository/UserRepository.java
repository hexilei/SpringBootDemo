package com.rmbin.elastic.repository;

import com.rmbin.elastic.model.UserElasModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserElasModel, Long> {

}
