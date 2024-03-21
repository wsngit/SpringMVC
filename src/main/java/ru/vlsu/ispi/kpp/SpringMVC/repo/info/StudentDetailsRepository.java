package ru.vlsu.ispi.kpp.SpringMVC.repo.info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vlsu.ispi.kpp.SpringMVC.model.info.StudentDetails;

import java.util.List;
import java.util.Optional;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {
    @Query("SELECT sd FROM StudentDetails sd WHERE sd.student IN (:students)")
    List<StudentDetails> findAllByStudent(@Param("students") List<Long> students);

    Optional<StudentDetails> findByStudent(Long sid);


}
