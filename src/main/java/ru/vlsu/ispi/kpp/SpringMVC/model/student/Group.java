package ru.vlsu.ispi.kpp.SpringMVC.model.student;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = { "students", "courses" })
public class Group {
    @JsonCreator
    public Group(@JsonProperty("name") String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="group_name", nullable = false,
            length = 32, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="group")
    private List<Student> students;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Course> courses;

}
