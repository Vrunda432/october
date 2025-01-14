package com.session.october.services;

import java.lang.annotation.Retention; 
import java.lang.annotation.RetentionPolicy; 
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;


@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE)
@Service
public @interface MyTestAnnotation { 
	
}