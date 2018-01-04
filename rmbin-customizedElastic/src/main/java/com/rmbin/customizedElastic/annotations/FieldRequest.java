package com.rmbin.customizedElastic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE)
public @interface FieldRequest {
	
	String[] fields();
	
	String name();
	
	String index ();
	
	String type();

}
