package org.rmbin.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpaceModel {

	@Value("${com.rmbin.space}")
	private String companyName;
	
	@Value("${com.rmbin.title}")
	private String title;
	
	@Value("${com.rmbin.userName}")
	private String userName;

	@Value("${com.rmbin.welcome}")
	private String welcome;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	
}
