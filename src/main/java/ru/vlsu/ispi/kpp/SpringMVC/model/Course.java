package ru.vlsu.ispi.kpp.SpringMVC.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cources")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 32, unique = true)
    String name;
}
