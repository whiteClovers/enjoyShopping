package com.ckwl.likemoney.frame.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTransaction {
	boolean autoCommit() default false ;
	boolean readOnly() ;
	int isolation() default 4 ;
}
