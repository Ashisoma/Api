package com.example.Api.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Student One = new Student(

                    "One",
                    "one@gmail.com",
                    LocalDate.of(2000, 5, 20)
            );
            Student Flo = new Student(

                    "Flo",
                    "flo@gmail.com",
                    LocalDate.of(2001, 11, 12)
            );
            Student Melo = new Student(

                    "Melo",
                    "melo@gmail.com",
                    LocalDate.of(1998, 4, 24)
            );

            repository.saveAll(
                    List.of(One, Flo, Melo)
            );
        };
    }
}
