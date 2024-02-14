package ru.vlsu.ispi.kpp.SpringMVC.model;


import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="gruop_name", nullable = false,
            length = 32, unique = true)
    private String name;

}
