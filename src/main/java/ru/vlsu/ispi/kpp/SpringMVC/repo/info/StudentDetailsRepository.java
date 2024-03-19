package ru.vlsu.ispi.kpp.SpringMVC.repo.info;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.ispi.kpp.SpringMVC.model.info.StudentDetails;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {
}
