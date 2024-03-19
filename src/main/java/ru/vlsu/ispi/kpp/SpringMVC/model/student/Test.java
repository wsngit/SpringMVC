package ru.vlsu.ispi.kpp.SpringMVC.model.student;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tests")
@Data
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 32)
    private String name;

    @ManyToOne
    @JoinColumn(name="course", nullable=false)
    private Course course;

    @OneToMany(mappedBy="test")
    private List<TestResult> testResults;

}
