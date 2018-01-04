package com.rmbin.common.utils.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonServiceImpl implements JsonService {

	private static ObjectMapper mapper = new ObjectMapper();
	
	static{
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
	
	@Override
	public <T> String toJson(T t) throws Exception {
		return mapper.writeValueAsString(t);
	}

	@Override
	public <T> T toModel(String json, Class<T> clazz) throws Exception {
		return mapper.readValue(json.getBytes(), clazz);
	}

	@Override
	public <T> List<T> toModelList(String json, Class<T> clazz) throws Exception {
		return (List<T>)toModel(json,clazz);
	}

}
