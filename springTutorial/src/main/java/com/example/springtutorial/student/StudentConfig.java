package com.example.springtutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Vlad = new Student(
                    "Vlad",
                    "vlad@yahoo.com",
                    LocalDate.of(2001, JANUARY, 17),
                    20
            );

            Student Cata = new Student(
                    "Cata",
                    "cata@gmail.com",
                    LocalDate.of(2000, JANUARY, 17),
                    21
            );

            repository.saveAll(Arrays.asList(Vlad, Cata));
        };
    }
}
