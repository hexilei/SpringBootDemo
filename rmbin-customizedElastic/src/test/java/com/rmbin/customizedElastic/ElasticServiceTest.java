package com.rmbin.customizedElastic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rmbin.customizedElastic.cache.FieldsCache;
import com.rmbin.customizedElastic.server.ElasticSearchAdminService;
import com.rmbin.customizedElastic.server.ElasticSearchService;
import com.rmbin.model.UserModel;
import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticServiceTest {
	
	private static final Log logger = LogFactory.getLog(ElasticSearchService.class);

	@Autowired
	ElasticSearchService service;
	
	@Autowired
	ElasticSearchAdminService admin;
	
	final static  String Index = "users";
	
	static final String TYPE = "user";
	
	@Test
	public void isExist() throws Exception
	{
		Assert.assertEquals(true, service.isExisted("users"));
	}
	
	@Test
	public void createIndex() throws Exception
	{
		XContentBuilder source = XContentFactory.jsonBuilder();
		source.startObject().field("firstName", "He").field("lastName", "Bing").field("sexy","Male").endObject();
		service.createIndex(Index, "user", UUID.randomUUID().toString(), source);
	}
	
	@Test
	public void updateIndex() throws Exception
	{
		XContentBuilder source = XContentFactory.jsonBuilder();
		source.startObject().field("firstName","UserName1").field("lastName","UserLastName").field("sexy","Female").endObject();
		service.updateIndex(Index, TYPE, "1", source);
	}
	
	@Test
	public void findIndex() throws Exception
	{
		Map map = service.getDocByIndex(Index, TYPE, "cbccb475-82ed-4068-8607-e2b2f18a576f").getSource();
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext())
		{
			String key = keys.next();  
			logger.info("Key is ==" + key + ", value=="+(String)map.get(key));
		}
	}
	
	@Test
	public void findMultiIndex() throws Exception
	{
		MultiGetResponse multiRes = service.getDocByMultiIndex(Index, TYPE, "3a81411a-ae4c-45da-a652-418175bc5b4b");
		Iterator itemIte = multiRes.iterator();
		while(itemIte.hasNext())
		{
			MultiGetItemResponse itemRes = (MultiGetItemResponse)itemIte.next();
			Map map = itemRes.getResponse().getSource();
			Iterator<String> keys = map.keySet().iterator();
			while(keys.hasNext())
			{
				String key = keys.next();  
				logger.info("Multiple search ==> Key is ==" + key + ", value=="+(String)map.get(key));
			}
		}
	}
	
	@Test()
	public void checkFieldsCache()
	{
		FieldsCache.getInstance().getFields(UserModel.class);
	}
	
	@Test
	public void checkCache()
	{
		FieldsCache.getInstance().getFields(UserModel.class);
	}
	
	@Test
	public void testPhraseQuery() throws Exception
	{
		service.findDocumentByQuery("users", "user", "firstName", "He");
	}
	
	@Test
	public void testCreateIndex() throws Exception
	{
		String indexName = "test";
		if(!admin.isExisting(indexName))
		{
			admin.createIndex(indexName);
		}
		else
		{
			Assert.assertEquals(true, admin.isExisting(indexName));
		}
	}
	
	@Test
	public void phraseQuery() throws Exception
	{
		List<String> fields = new ArrayList<String>();
		fields.add("firstName");
		service.phraseQuery("users", "user",fields, "He");
	}
	
	@Test
	public void scrollPhraseQuery() throws Exception
	{
		List<String> fields = new ArrayList<String>();
		fields.add("firstName");
		service.scrollPhraseQuery("users", "user",fields, "He");
	}
}
