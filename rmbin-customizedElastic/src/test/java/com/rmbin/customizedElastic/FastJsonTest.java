package com.rmbin.customizedElastic;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FastJsonTest {
	
	@Test
	public void printJson() throws JsonProcessingException
	{
		User user1=new User();
		user1.setUserName("tester1");
		user1.setPassword("tpwd1");
		User user2 = new User();
		user2.setUserName("tester2");
		user2.setPassword("tpwd2");
		Manager manager = new Manager();
		manager.addUser(user1);
		manager.addUser(user2);
		
		ObjectMapper mapper = new ObjectMapper();
		String managerStr = mapper.writerWithView(Views.Normal.class).writeValueAsString(manager);
		System.out.println(managerStr);
		// if no view is annotated, all fields 
	}

}
