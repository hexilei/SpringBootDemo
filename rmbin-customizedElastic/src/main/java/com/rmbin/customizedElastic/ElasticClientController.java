package com.rmbin.customizedElastic;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmbin.customizedElastic.client.ElasticSearchClient;

@RestController
@RequestMapping(value="/elastic/util")
public class ElasticClientController {

	//@Autowired
	private ElasticSearchClient client;
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET,produces="application/text;charset=UTF-8")
	public String testElastic(@PathVariable("id") String userId)
	{
	//	GetResponse res = client.prepareGet("user","user", userId).get();
		return "hello";
	}
}
