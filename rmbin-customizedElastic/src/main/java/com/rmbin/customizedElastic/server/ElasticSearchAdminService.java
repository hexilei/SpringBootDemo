package com.rmbin.customizedElastic.server;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchAdminService {
	
	@Autowired
	private ElasticSearchService admin;
	
	public CreateIndexResponse createIndex(String indexName) throws Exception
	{
		CreateIndexResponse indexRes = admin.getSearchClient().admin().indices().prepareCreate(indexName).get();
		return indexRes;
	}
	
	/**
	 * Check if the index exists
	 * @param indexName
	 * @return
	 * @throws Exception
	 */
	public boolean isExisting(String indexName) throws Exception
	{
		boolean existed = admin.getSearchClient().admin().indices().exists(new IndicesExistsRequest(indexName)).get().isExists();
		return existed;
	}
	
	

}
