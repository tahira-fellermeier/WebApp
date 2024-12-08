package edu.fra.uas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.controller.GradeController;
import edu.fra.uas.model.Grade;
import edu.fra.uas.service.NotenService;


@SpringBootApplication
public class NotenDurchschnittApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotenDurchschnittApplication.class, args);
    }

        @Autowired
    private GradeController gradeController;

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                
                System.out.println("Application started (fr)");

                gradeController.initStatistik();
            }

        };
        return action;
    }
}
