 package com.session.october;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories(basePackages = {"com.session.october"})
//@ComponentScan("com")//very bed decliartion
//@Componenent("com.session.october)==> default it will take the particular app class pkg component base pkgs.
// @ComponentScan({"com.session.october.controllers","com.session.october.services","com.session.october.repositories"})//this is best way
public class OctoberApplication { 

	public static void main(String[] args) {
		SpringApplication.run(OctoberApplication.class, args);
	}
//	@PostConstruct
//	public void init() {
//		log.info("Application Initalized");
//	}
//	@PreDestroy
//	public void destroy() {
//		log.info("Destroying the application");
// 	}

}
 