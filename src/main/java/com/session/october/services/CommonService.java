package com.session.october.services;

//import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@MyTestAnnotation
@Slf4j
public class CommonService {
public void test() {
	log.info("test() method called from CommonService.");
}
}
