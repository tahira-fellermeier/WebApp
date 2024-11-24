package edu.fra.uas.session;

import java.util.UUID; //zur Generierung einzigartiger Identifikatoren "Universally Unique Identifier " ie. 123e4567-e89b-12d3-a456-426614174000

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = "request") //prototype, singleton, request
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//alternative Möglichkeit, den Geltungsbereich auf session zu setzen, 
//neue Instanz des Beans für jede HTTP-Session erstellt 
//proxyMode wird verwendet, um anzugeben, wie der Proxy für den Bean erstellt werden soll.

public class Session {

	private static final Logger log = LoggerFactory.getLogger(Session.class);
	
	private String sessionName;
	
	public Session() {
		sessionName = UUID.randomUUID().toString();
		log.info("Session Bean constructed --> sessionName is: " +  sessionName);
	}
	
	public String getSessionName() {
		return sessionName;
	}
	
}
