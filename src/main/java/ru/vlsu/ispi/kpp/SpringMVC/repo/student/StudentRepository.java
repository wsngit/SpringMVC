package ru.vlsu.ispi.kpp.SpringMVC.repo.student;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.ispi.kpp.SpringMVC.model.student.Group;
import ru.vlsu.ispi.kpp.SpringMVC.model.student.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByGroup(Group group);

    //Sorting results
    List<Student> findAllByGroupOrderByIdAsc(Group group);
    List<Student> findAllByGroupOrderByIdDesc(Group group);
    List<Student> findAllByGroup(Group group, Sort sort);

    //Limiting results
    Optional<Student> findTopByGroup(Group group);
    Optional<Student> findFirstByGroup(Group group);
    List<Student> findAllByGroup(Group group, Pageable pageable);
}
