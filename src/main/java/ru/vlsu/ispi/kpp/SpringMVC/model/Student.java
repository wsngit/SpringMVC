package ru.vlsu.ispi.kpp.SpringMVC.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details", referencedColumnName = "id")
    private StudentDetails details;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    private Group group;

    @OneToMany(mappedBy="student")
    private List<TestResult> testResults;

}
