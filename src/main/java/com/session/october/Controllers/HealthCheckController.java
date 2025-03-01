package com.session.october.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.october.services.AccountService;
import com.session.october.services.CommonService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/health/check")
@Slf4j
//@RequiredArgsConstructor
public class HealthCheckController {

	@Autowired
	private  @Qualifier("jpaAccountService")AccountService accountService;
	private CommonService service;

//	@Autowired
//	private @Qualifier("JdbcAccountService") AccountService accountService;

	@GetMapping
	public HttpStatus healthCheck() {
		System.out.println("Reached -> healthCheck"); // Reached -> healthCheck
		log.info(" Re ached -> healthCheck"); //
		service.test();
		accountService.print();
		return HttpStatus.OK;
	}
}