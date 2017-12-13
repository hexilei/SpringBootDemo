package com.rmbin.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;

public class UserModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String userName;
	
	private String email;
	
	private boolean sexy;
	
	private List<ContactModel> contacts;
	
	public UserModel(String userId,String userName)
	{
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSexy() {
		return sexy;
	}

	public void setSexy(boolean sexy) {
		this.sexy = sexy;
	}

	public List<ContactModel> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactModel> contacts) {
		this.contacts = contacts;
	}
	
	@Override
	public String toString() {
		return this.userId +"/" + this.userName;
	}
	
	@Override
	public int hashCode() {
		int hash = 37;
		hash = hash + this.getUserId().hashCode() +this.getUserName().hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UserModel))
		{
			return false;
		}
		UserModel user = (UserModel)obj;
		if(user.getUserId() != this.getUserId() && user.getUserName() != this.getUserName())
		{
			return false;
		}
		return false;
	}

}
