package ru.vlsu.ispi.kpp.SpringMVC.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "student_details",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "first_name", "last_name" }) })
@Data
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private Date birthdate;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;


}
