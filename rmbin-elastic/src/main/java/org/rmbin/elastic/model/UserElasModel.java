package org.rmbin.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;

import com.rmbin.model.UserModel;

@Document(indexName="userindex",type="user")
public class UserElasModel extends UserModel {

	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserElasModel(String userId, String userName) {
		super(userId, userName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
