package ru.vlsu.ispi.kpp.SpringMVC.model.info;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "student_details",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "first_name", "last_name" }) })
@Data
@NoArgsConstructor
@JsonPropertyOrder({ "id", "firstName" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthdate;

    @JsonIgnore
    private long student;
}
