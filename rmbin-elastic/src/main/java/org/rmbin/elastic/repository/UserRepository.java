package org.rmbin.elastic.repository;

import org.rmbin.elastic.model.UserElasModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserElasModel, Long> {

}
