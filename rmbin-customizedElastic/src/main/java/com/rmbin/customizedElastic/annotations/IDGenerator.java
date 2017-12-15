package com.rmbin.customizedElastic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
public @interface IDGenerator {
	
	String value() default "";

}
