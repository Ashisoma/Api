package com.example.Api.Student;

import com.example.Api.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student studnet){
        studentService.addNewStudent(studnet);
    }

    @DeleteMapping(path = "{studentId")
    public void deleteStudents(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public  void updateStudentById(@PathVariable("studentId") Long studentId,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }
}
