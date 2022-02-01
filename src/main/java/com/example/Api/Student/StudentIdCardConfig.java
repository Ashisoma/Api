package com.example.Api.Student;

import com.example.Api.entity.Student;
import com.example.Api.entity.StudentIdCard;
import com.example.Api.repo.StudentIdCardRepository;
import com.example.Api.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentIdCardConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository idCardRepository){
        return args -> {
            /*
            Faker faker = new Faker();

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));

             */

            Student ian = new Student(
                    "Yeye",
                    "Okoth",
                    20,
                    "ian@gmail.com"
            );
            StudentIdCard studentIdCard = new StudentIdCard(
                    "156789",
                    ian);
//            studentRepository.save(ian);

//            idCardRepository.save(studentIdCard);
    };
        /*

        private void generateRandomStudents(StudentRepository studentRepository) {
            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
                Student student = new Student(
                        firstName,
                        lastName,
                        email,
                        faker.number().numberBetween(17, 55));
                studentRepository.save(student);
            }
         */
        }
}
