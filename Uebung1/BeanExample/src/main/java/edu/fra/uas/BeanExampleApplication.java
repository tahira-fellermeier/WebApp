package edu.fra.uas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanExampleApplication.class, args);
	}

	@Bean //Methode init erzeugt ein Bean
	CommandLineRunner init() {
		CommandLineRunner action = new CommandLineRunner() { //Interface von Spring, anonymes (sofort nutzbares), inneres Objekt 
			@Override
			public void run(String... args) throws Exception { //beliebig viele String-Werte können übergeben werden, sie werden automatisch in ein String-Array umgewandelt
				System.out.println("Hello World!");
			}
		};
		return action; //CommandLineRunner Objekt "action" wird zurückgegeben und von Spring verwaltet
	}

}
