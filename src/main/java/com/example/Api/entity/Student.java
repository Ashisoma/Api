package com.example.Api.entity;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id",
            updatable = false
    )
    private Long id;
    @Column(name = "first_name",
            columnDefinition = "TEXT",
            nullable = false)
    private String firstName;
    @Column(name = "second_name",
            columnDefinition = "TEXT",
            nullable = false)
    private String secondName;
    @Column(name = "age",
            nullable = false)
    private Integer age;
    @Column(name = "email",
            columnDefinition = "TEXT",
            nullable = false)
    private String email;

    @OneToOne(
            mappedBy = "student",
            orphanRemoval = true)
    private StudentIdCard studentIdCard;

    public StudentIdCard getStudentIdCard() {
        return studentIdCard;
    }

    public Student() {
    }

    public Student(Long id, String firstName, String secondName, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
    }

    public Student(String firstName, String secondName, Integer age, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
