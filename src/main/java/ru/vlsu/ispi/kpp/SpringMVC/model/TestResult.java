package ru.vlsu.ispi.kpp.SpringMVC.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "test_results")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private int result;

    @ManyToOne
    @JoinColumn(name="student", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="test", nullable=false)
    private Test test;
}
