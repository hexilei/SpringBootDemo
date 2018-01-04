package com.rmbin.common.utils.json;

import java.util.List;

public interface JsonService {

	public <T> String toJson(T t) throws Exception;
	
	public <T> T toModel(String json, Class<T> clazz)  throws Exception;
	
	public <T> List<T> toModelList(String json, Class<T> clazz)  throws Exception;
}
