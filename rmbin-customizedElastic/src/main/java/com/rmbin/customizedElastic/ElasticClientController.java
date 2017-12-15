package com.rmbin.customizedElastic;

import java.util.Map;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/elastic/util")
public class ElasticClientController {

	@Autowired
	private TransportClient  client;
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET,produces="application/text;charset=UTF-8")
	public String testElastic(@PathVariable("id") String userId)
	{
		GetResponse res = client.prepareGet("users", "user",userId).get();
		Map<String,Object> users = res.getSource();
		System.out.println("Index"+res.getIndex());
		return "hello";
	}
}
