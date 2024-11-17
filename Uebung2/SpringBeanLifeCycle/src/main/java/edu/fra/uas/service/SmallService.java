package edu.fra.uas.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service // for business logic
@Component // managed component
//@Repository // for persistence
public class SmallService {

	private static final Logger log = LoggerFactory.getLogger(SmallService.class);
	
	private String state = "preInitialization";

	@PostConstruct
    public void postConstruct() {
		log.info("postConstruct() -->  " + state);
		state = "PostConstruct"; //Ändert state
		log.info("postConstruct() -->  " + state);
	}
	
	public void doSomething() { // wie getState()
		log.info("doSomething() --> " + state);
	}
	
	@PreDestroy
    public void preDestroy() {
		state = "PreDestroy"; //ändert state
		log.info("preDestroy() --> " + state);
	}
	
}
