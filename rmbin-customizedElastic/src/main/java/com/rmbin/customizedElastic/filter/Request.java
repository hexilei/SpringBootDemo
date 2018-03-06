package com.rmbin.customizedElastic.filter;

import java.util.Map;

public interface Request {
	
	public Response get(String index, String type,String url);
	
	public Response get(String[] indexes, String[] types, String url);
	
	public Response get(String[] indexes, String[] types, Map<String, String> params);

}
