package ru.vlsu.ispi.kpp.SpringMVC.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student_details",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "first_name", "last_name" }) })
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private Date birthdate;

}
