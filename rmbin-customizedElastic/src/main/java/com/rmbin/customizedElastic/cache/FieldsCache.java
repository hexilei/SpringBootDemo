package com.rmbin.customizedElastic.cache;

import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FieldsCache {
	
	private Map<String, SoftReference<Field[]>> fields = new ConcurrentHashMap<String, SoftReference<Field[]>>();
	
	private FieldsCache(){}
	
	static class FieldsCacheHolder
	{
		static  FieldsCache instance = new FieldsCache();
	}
	
	public static FieldsCache getInstance()
	{
		return FieldsCacheHolder.instance;
	}
 
	public Field[] getFields(Class clazz)
	{
		String className = clazz.getName();
		boolean recyled = false;
		SoftReference<Field[]> sr = fields.get(className);
		if(fields.containsKey(className))
		{
			System.out.println("test");
			Field[] srFields = sr.get();
			if(srFields != null)
			{
				return srFields;
			}
		}
		List<Field> listedFields = new ArrayList<Field>();
		Field[] decFields = clazz.getDeclaredFields();
		listedFields.addAll(filterFields(decFields));
		Class parent = clazz.getSuperclass();
		while(parent != Object.class)
		{
			listedFields.addAll(filterFields(parent.getDeclaredFields())); 
			parent = parent.getSuperclass();
		}
		sr = new SoftReference<Field[]>((Field[])listedFields.toArray());
		fields.put(className, sr);
		return (Field[])listedFields.toArray();
	}
	
	public List<Field> filterFields(Field[] fields)
	{
		List<Field> list = new ArrayList<Field>();
		for(Field field: fields)
		{
			if(!Modifier.isStatic(field.getModifiers()))
			{
				list.add(field);
			}
		}
		return list;
	}
	
}
