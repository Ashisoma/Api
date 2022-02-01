package com.example.Api.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "studentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_id_card_number_unique",
                        columnNames = "card_number"
                )
        }
)
public class StudentIdCard {

    // NEW BRANCH FOR THE ENTITY RELATIONSHIP
    @Id
    @SequenceGenerator(
            name = "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_card_id_sequence"
    )
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "card_number",
            nullable = false,
            length = 15)
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "student_id_fk"
                )
    )
    private Student student;

    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
