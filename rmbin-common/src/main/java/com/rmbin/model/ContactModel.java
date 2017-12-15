package com.rmbin.model;

import java.io.Serializable;

public class ContactModel extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String phoneNum;
	
	private String address1;
	
	private String address2;
	
	private boolean isPrimary;
	
	private String city;
	
	private String country;
	
	private String province;
	
	private String email;
	
	private String weChat;
	
	private String userName;
	
	private String desc;
	
	private boolean sexy;
	
	public ContactModel(String userName,String phoneNum,String address)
	{
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.address1 = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isSexy() {
		return sexy;
	}

	public void setSexy(boolean sexy) {
		this.sexy = sexy;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ContactModel))
		{
			return false;
		}
		ContactModel contact = (ContactModel)obj;
		if(contact.userId != this.userId)
		{
			return false;
		}
		if(contact.getUserId() == this.userId && contact.getUserName() == this.userName && contact.getPhoneNum() == this.phoneNum)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(50);
		return sb.append(this.getUserId()).append("/").append(this.getUserName()).append("/").append(this.getPhoneNum()).toString();
	}
	
	@Override
	public int hashCode() {
		int hash = 37;
		hash = hash + this.getUserId().hashCode() + this.getUserName().hashCode() + this.getPhoneNum().hashCode();
		return hash;
	}
}
