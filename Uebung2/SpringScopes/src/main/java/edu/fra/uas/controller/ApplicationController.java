package edu.fra.uas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.fra.uas.session.Session;

@Controller
public class ApplicationController {

	private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	ApplicationContext applicationContext;
	
	public ApplicationController() {} //Konstruktor, meistens bei Beans nicht benötigt
	
	@RequestMapping(value = "/path1") // diese Methode wird verwendet, wenn eine HTTP-Anfrage an die URL /path1 gesendet wird.
	public String showPage1() {
		Session session1 = (Session) applicationContext.getBean(Session.class); //bei jedem Aufruf dieser Methode wird eine neue Instanz erstellt
		Session session2 = (Session) applicationContext.getBean(Session.class);
		log.info(session1.getSessionName());
		log.info(session2.getSessionName());
		return "page"; //Rückgabewert -  eine entsprechende View (z.B. eine HTML-Seite) gerendert wird.
	}
	// "page" könnte in eine Datei wie page.html oder page.jsp umgewandelt werden, 
	// die sich in einem bestimmten Verzeichnis (z. B. src/main/resources/templates für Thymeleaf oder src/main/webapp/WEB-INF/jsp für JSP) befindet.
	@RequestMapping(value = "/path2")
	public String showPage2() {
		Session session1 = (Session) applicationContext.getBean(Session.class);
		Session session2 = (Session) applicationContext.getBean(Session.class);
		log.info(session1.getSessionName());
		log.info(session2.getSessionName());
		return "page";
	}
	
}
