package com.rmbin.common.utils.json;


public class JsonFactory {
	
	enum Service
	{
		FASTJSON, JSONLIB;
	}
	
	public JsonService getSerice(String type)
	{
		JsonService service = null;
		if(Service.valueOf(type) == Service.FASTJSON)
		{
			service = new JsonServiceImp();
		}
		else if(Service.valueOf(type) == Service.JSONLIB)
		{
			service = new JacksonJsonServiceImpl();
		}
		return service;
	}

}
