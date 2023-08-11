package com.example.springdemoapp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRpository repository) {
        return args -> {
            Student yusuf = new Student(
                    "Yusuf",
                    "Yusuf@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 5)

            );

            Student ahmed = new Student(
                    "Ahmed",
                    "Ahmed@gmail.com",
                    LocalDate.of(2001, Month.FEBRUARY, 5)
            );

            Student mohamed = new Student(
                    "Mohamed",
                    "Mohamed@gmail.com",
                    LocalDate.of(2001, Month.MARCH, 5)
            );

            repository.saveAll(
                    List.of(yusuf, ahmed, mohamed)
            );
        };
    }
}
