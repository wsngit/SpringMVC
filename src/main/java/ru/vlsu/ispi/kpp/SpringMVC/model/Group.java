package ru.vlsu.ispi.kpp.SpringMVC.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="group_name", nullable = false,
            length = 32, unique = true)
    private String name;

    @OneToMany(mappedBy="group")
    private List<Student> students;

    @ManyToMany(mappedBy = "groups")
    private List<Course> courses;

}
