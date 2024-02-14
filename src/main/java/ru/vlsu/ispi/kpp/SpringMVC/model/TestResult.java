package ru.vlsu.ispi.kpp.SpringMVC.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tests")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
