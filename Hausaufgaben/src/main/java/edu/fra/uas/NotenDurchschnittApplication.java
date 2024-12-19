package edu.fra.uas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.model.Grade;
import edu.fra.uas.repository.GradeRepository;

@SpringBootApplication
public class NotenDurchschnittApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotenDurchschnittApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(GradeRepository gradeRepository) {
        return args -> {
            // Initialize some test data
            gradeRepository.put(1L, new Grade(1, "Statistik", 1.7, 5));
            gradeRepository.put(2L, new Grade(2, "Web", 2.3, 5));
            gradeRepository.put(3L, new Grade(3, "Internetrecht", 3.4, 5));

            // You can print to verify
            gradeRepository.forEach((id, grade) -> System.out.println(grade));
        };
    }

}
