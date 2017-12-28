package com.rmbin.customizedElastic.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rmbin.customizedElastic.client.ElasticSearchClient;

@Component
public class ElasticSearchService {
	
	private Log logger = LogFactory.getLog(ElasticSearchService.class);
	
	@Autowired
	private ElasticSearchClient client;
	
	public TransportClient getSearchClient() throws Exception
	{
		return client.getObject();
	}
	
	/**
	 * TODO id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean isExisted(String id) throws Exception
	{
		return getSearchClient().admin().indices().prepareExists(id).execute().actionGet().isExists();
	}
	
	public void getIndices() throws Exception
	{
		IndicesAdminClient indices = getSearchClient().admin().indices();
	}
	
	public void createIndex(String index, String type,String id,XContentBuilder source) throws Exception
	{
		IndexResponse response = getSearchClient().prepareIndex(index, type, id).setSource(source).execute().actionGet();
		logger.info("Index create status ==>"+response.status().getStatus());
	}
	
	public void deleteIndex(String index, String type,String id) throws Exception
	{
		DeleteResponse response = getSearchClient().prepareDelete(index,	type, id).execute().actionGet();
		logger.info("Index delete status ==>"+response.status().getStatus());
	}
	
	public void updateIndex(String index, String type, String id, XContentBuilder source) throws Exception
	{
		UpdateResponse response = getSearchClient().prepareUpdate(index, type, id).setDoc(source).execute().actionGet();
		logger.info("Index update status ==>"+response.status().getStatus());
	}
	
	public GetResponse getDocByIndex(String index, String type, String id) throws Exception
	{
		GetResponse response = getSearchClient().prepareGet(index, type, id).get();
		return response;
	}
	
	public MultiGetResponse getDocByMultiIndex(String index, String type, String id) throws Exception
	{
		MultiGetResponse res = getSearchClient().prepareMultiGet().add(index, type, id).get();
		return res;
	}

}
