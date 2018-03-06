package com.rmbin.customizedElastic.server;

import static org.mockito.Matchers.intThat;

import java.util.Map;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.queryparser.xml.builders.BooleanQueryBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.CommonTermsQueryBuilder;
import org.elasticsearch.index.query.MatchPhrasePrefixQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.reindex.ScrollableHitSource.Hit;
import org.elasticsearch.index.search.MatchQuery;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rmbin.customizedElastic.client.ElasticSearchClient;
import com.rmbin.customizedElastic.core.Page;

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
	
	public void findDocumentByQuery(String index, String type,String field, String value) throws Exception
	{
		SearchResponse response = getSearchClient().prepareSearch(index).setQuery(QueryBuilders.matchPhraseQuery(field, value)).get();
		SearchHit[] hits = response.getHits().getHits();
		for(SearchHit hit: hits)
		{
			int docId = hit.docId();
			String id = hit.getId();
			float score = hit.getScore();
			Map map = hit.getSourceAsMap();
		}
	}
	
	public void phraseQuery(String index, String type, List<String> highters, String text) throws Exception
	{
		QueryStringQueryBuilder query = QueryBuilders.queryStringQuery(text);
		HighlightBuilder highlighter = new HighlightBuilder();
		for(String field:highters)
		{
			highlighter.field(field);
		}
		SearchRequestBuilder search  = getSearchClient().prepareSearch(index);
		search.highlighter(highlighter);
		SearchResponse response = search.setTypes(new String[]{type}).setQuery(query).get();
		SearchHits hits = response.getHits();
		List<String> result = new ArrayList<String>();
		for(SearchHit hit: hits.getHits())
		{
			result.add(hit.getSourceAsString());
		}
	}
	
	public void scrollPhraseQuery(String index, String type, List<String> fields, String text) throws Exception
	{
		SearchRequestBuilder requestBuilder = getSearchClient().prepareSearch(index);
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		for(String field:fields)
		{
			highlightBuilder.field(field, 1);
		}
		requestBuilder.highlighter(highlightBuilder);
		CommonTermsQueryBuilder phraseQuery1 = QueryBuilders.commonTermsQuery("firstName", "UserName");
		MatchPhraseQueryBuilder phraseQuery2 = QueryBuilders.matchPhraseQuery("firstName", "He");
		BoolQueryBuilder booleanQueryBuilder = QueryBuilders.boolQuery();
		booleanQueryBuilder.should().add(phraseQuery1);
		booleanQueryBuilder.should().add(phraseQuery2);
		
		Page page = new Page(20);
		SearchRequestBuilder request = requestBuilder.setTypes(new String[]{type}).setQuery(booleanQueryBuilder).setSize(page.getSize());
		request.setMinScore(new Float(0.001));
//		request.setScroll(new Scroll(TimeValue.MINUS_ONE));
		SearchResponse response = request.get();
//		String scrollId = response.getScrollId();
		SearchHits hits = response.getHits();
		List<String> result = new ArrayList<String>();
		for(SearchHit hit: hits.getHits())
		{
			result.add(hit.getSourceAsString());
		}
	}
	
	public void bulk(String index, String type)
	{
		
	}

}
