package com.example.Api.Student;

import com.example.Api.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/nameAndEqualAge")
    public List<Student> getWIthAgeAndNameStudents(@RequestParam(required = false)String firstName,
                                                   @RequestParam(required = false)Integer age){
        return studentService.getStudentWithAgeGreaterThanOrEqualTo(firstName, age);
    }


    @GetMapping("/nameAndNativeAge")
    public List<Student> getWithNativeAgeAndNameStudents(@RequestParam(required = false)String firstName,
                                                         @RequestParam(required = false)Integer age){
        return studentService.getStudentWithAgeGreaterThanOrEqualNative(firstName, age);
    }

    @PostMapping("/add")
    public void registerNewStudent(@RequestBody(required = false) Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/delete/{studentId}")
    public void deleteStudents(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "/update/{studentId}")
    public  void updateStudentById(@PathVariable("studentId") Long studentId,
                                   @RequestParam(required = false) String fname,
                                   @RequestParam(required = false) String sname,
                                   @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, fname,sname, email);
    }
}
