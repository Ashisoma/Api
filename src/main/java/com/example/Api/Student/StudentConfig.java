package com.example.Api.Student;

import com.example.Api.entity.Student;
import com.example.Api.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Student One = new Student(
                    "One",
                    "Ashisoma",
                    20,
                    "one@gmail.com"
            );

            Student Melo = new Student(
                    "Melo",
                    "Okoth",
                    20,
                    "melo@gmail.com"
            );

            repository.saveAll(
                    List.of(One, Melo)
            );
        };
    }


}
