package com.rmbin.common.utils.json;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import com.sdicons.json.mapper.helper.impl.ArrayMapper;
import com.sdicons.json.mapper.helper.impl.ObjectMapper;
import com.sdicons.json.parser.JSONParser;

public class JsonServiceImp implements JsonService {

	private ObjectMapper mapper = new ObjectMapper();
	
	private ArrayMapper arrayMapper = new ArrayMapper();
	
	@Override
	public <T> String toJson(T t) {
		return null;
	}

	@Override
	public <T> T toModel(String json, Class<T> clazz) throws Exception {
		JSONParser parser = new JSONParser(new ByteArrayInputStream(json.getBytes()));
		return (T)mapper.toJava(parser.nextValue(), clazz);
	}

	@Override
	public <T> java.util.List<T> toModelList(String json, Class<T> clazz) throws Exception {
		JSONParser parser = new JSONParser(new ByteArrayInputStream(json.getBytes()));
		T[] models = (T[])arrayMapper.toJava(parser.nextValue(), clazz);
		List<T> results = new ArrayList<T>();
		if(models != null)
		{
			for(T model: models)
			{
				results.add(model);
			}
		}
		return results;
	}

}
