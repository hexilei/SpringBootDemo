package com.rmbin.customizedElastic;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	
	private String managerName;
	
	List<User> users = new ArrayList<User>();

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user)
	{
		users.add(user);
	}

}
