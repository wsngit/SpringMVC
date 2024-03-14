package ru.vlsu.ispi.kpp.SpringMVC.model.course;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vlsu.ispi.kpp.SpringMVC.model.student.Group;

import java.util.List;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 64, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "groups_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    @OneToMany(mappedBy="course")
    private List<Test> tests;

    public Course(String name){
        this.name = name;
    }
}
