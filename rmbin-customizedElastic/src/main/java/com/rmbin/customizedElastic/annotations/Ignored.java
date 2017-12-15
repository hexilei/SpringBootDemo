package com.rmbin.customizedElastic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * It identifies the class which has this annotation will be ignored.
 * @author louis.he
 *
 */
@Target(value = {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignored {

}
