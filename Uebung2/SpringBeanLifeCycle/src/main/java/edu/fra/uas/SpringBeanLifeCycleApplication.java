package edu.fra.uas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.service.SmallService;

@SpringBootApplication
public class SpringBeanLifeCycleApplication {
	
	@Autowired
	private SmallService smallService;

	public static void main(String[] args) { //Einstieg
		SpringApplication.run(SpringBeanLifeCycleApplication.class, args); //Application starten
	}

	@Bean //Methode gibt ein Bean (Instanz von CommandLineRunner) zurück
	CommandLineRunner init() {
		CommandLineRunner action = new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				smallService.doSomething(); //ruft die Methode doSomething der Klasse SmallService auf
			}
		};
		return action;
	}
}
