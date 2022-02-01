package com.example.Api.Student;

import com.example.Api.entity.Student;
import com.example.Api.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentWithAgeGreaterThanOrEqualTo(String firstName, Integer age){
        return studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqual(firstName, age);
    }

    public List<Student> getStudentWithAgeGreaterThanOrEqualNative(String firstName, Integer age){
        return studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(firstName, age);
    }

    public int deleteStudentById(Long id){
        return studentRepository.deleteStudentById(id);
    }
    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.
                findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email already exists");
        }

        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Student id: " + studentId + "does not exist!");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String fname, String sname, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow( () ->
                new IllegalStateException("Student with id :" + studentId + "does not exist"));
        if (fname != null && fname.length()>0 && !Objects.equals(student.getFirstName(),fname))
        {
            student.setFirstName(fname);
        }
        if (sname != null && sname.length()>0 && !Objects.equals(student.getSecondName(),sname))
        {
            student.setSecondName(sname);
        }
        if (email != null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            student.setEmail(email);
        }
    }
}
