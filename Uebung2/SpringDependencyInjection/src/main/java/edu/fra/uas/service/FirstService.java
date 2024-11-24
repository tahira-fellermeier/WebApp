package edu.fra.uas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

	// Constructor Injection: im ersten Schritt auskommentieren
	//@Autowired //so geht, ist aber aufwendig
	private SecondService secondService;

	//public FirstService() {
	//	secondService = new SecondService();
	//}

	// Constructor Injection
	@Autowired
	public FirstService(SecondService secondService) { //Diese Art sieht man am meisten. Viele Beans auf einmal verwalten, @autowired nur einmal schreinben
		this.secondService = secondService;
	}

	// Setter Injection //zu veraltet, überspringen. Man sieht es in Firmen auch nicht mehr
	// @Autowired
	// public void setSecondService(SecondService secondService) {
	// this.secondService = secondService;
	// }

	public void doSomething() {
		secondService.doSomething();
	}

}
