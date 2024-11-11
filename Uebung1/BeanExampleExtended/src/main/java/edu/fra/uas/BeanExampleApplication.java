package edu.fra.uas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.service.MessageService;

@SpringBootApplication
public class BeanExampleApplication {

	@Autowired //injiziert. Methoden und Eigenschaften von Klasse zugreifbar, ohne es selbst instanziieren zu müssen.
	private MessageService messageService; 
	public static void main(String[] args) {
		SpringApplication.run(BeanExampleApplication.class, args); //Spring-Anwendung starten
	}

	@Bean
	CommandLineRunner init() {
		CommandLineRunner action = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception { //verpflichtet Spring, sich auf verschiedene Arten von Fehler vorzubereiten und behandeln (ie. durch einen try-catch-Block)
				messageService.setMessage("Hello World!");
				System.out.println(messageService.getMessage());
				messageService.setMessage("--> HHHOHHH <--");
				System.out.println(messageService.getMessage());
			}
		};
		return action;
	}

}
