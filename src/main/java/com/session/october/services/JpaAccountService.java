package com.session.october.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("jpaAccountService")
@Slf4j
public class JpaAccountService extends AccountService{

	@Override
	public void print() {
		
		log.info("From Jpa Account Service.");
	}
  
}
