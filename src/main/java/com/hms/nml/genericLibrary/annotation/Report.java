package com.hms.nml.genericLibrary.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

/**
 * In this annotation we created our own annotations
 * @author amruth
 *
 */
public @interface Report {
	
	//	() is the parameter in annotations[it is not a method]  
	public String author(); 
	public String[] category() default "regression";
}
