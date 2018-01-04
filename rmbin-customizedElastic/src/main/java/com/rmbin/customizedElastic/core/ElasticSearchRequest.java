package com.rmbin.customizedElastic.core;

import java.util.HashMap;
import java.util.Map;

public class ElasticSearchRequest {
	
	private String index;
	
	private String type;
	
	private Map<String, String> fields = new HashMap<String,String>();
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void addFields(Map<String, String> fields) {
		this.fields.putAll(fields);
	}

	
	
	

}
