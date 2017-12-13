package com.rmbin.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rmbin.model.ContactModel;
import com.rmbin.model.UserModel;

@RestController
@RequestMapping(value="/home")
public class IndexHome {
	
	@RequestMapping(value="/sayHelloStr",method=RequestMethod.GET)
	public String sayHello()
	{
		return "Hey, I'm louis.";
	}
	
	@RequestMapping(value="/getUserByJson",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
	public UserModel getUser(String userId)
	{
		UserModel user = new UserModel(UUID.randomUUID().toString(),"louis");
		return user;
	}
	
	@RequestMapping(value="/getUserByxml",method=RequestMethod.GET,produces={"application/xml;cahrset=UTF-8"})
	public UserModel getUserByXML(String userId)
	{
		UserModel user = new UserModel(UUID.randomUUID().toString(),"louis");
		return user;
	}
	
	@RequestMapping(value="/getUserByIdPara/{id}",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
	public UserModel findUserByUserId(@PathVariable("id") String id)
	{
		UserModel user = new UserModel(UUID.randomUUID().toString(),"Louis");
		user.setEmail("hebing_o@hotmail.com");
		ContactModel contact = new ContactModel("LeiGuangHua","13826540142","JingChen");
		List<ContactModel> contacts = new ArrayList<ContactModel>();
		contacts.add(contact);
		user.setContacts(contacts);
		return user;
	}
	
	@RequestMapping(value="/getUserByContactId",method=RequestMethod.GET,produces={"application/xml;charset=UTF-8"})
	public UserModel findUserByContact(@RequestParam("id") String contactId)
	{
		UserModel user = new UserModel(UUID.randomUUID().toString(),"Louis");
		user.setEmail("hebing_o@hotmail.com");
		ContactModel contact = new ContactModel("LeiGuangHua","13826540142","JingChen");
		List<ContactModel> contacts = new ArrayList<ContactModel>();
		contacts.add(contact);
		user.setContacts(contacts);
		return user; 
	}
	

}
