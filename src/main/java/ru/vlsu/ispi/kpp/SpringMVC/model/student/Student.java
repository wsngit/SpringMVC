package ru.vlsu.ispi.kpp.SpringMVC.model.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    @JsonIgnore
    private Group group;

    @JsonProperty("group")
    public String getGroupName(){
        return group != null ? group.getName() : "";
    }

    @OneToMany(mappedBy="student")
    @JsonIgnore
    private List<TestResult> testResults;

}
