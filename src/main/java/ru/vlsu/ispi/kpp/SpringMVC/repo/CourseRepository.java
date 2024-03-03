package ru.vlsu.ispi.kpp.SpringMVC.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vlsu.ispi.kpp.SpringMVC.model.Course;
import ru.vlsu.ispi.kpp.SpringMVC.model.Group;
import ru.vlsu.ispi.kpp.SpringMVC.model.Student;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE :group MEMBER OF c.groups")
    List<Course> findAllByGroup(@Param("group") Group group);

    @Query("SELECT c FROM Course c LEFT JOIN Student s ON s.group MEMBER OF c.groups WHERE s = :student")
    List<Course> findAllByStudent(@Param("student") Student student);

    @Modifying
    @Query("update Course c set c.name = :name where c = :course")
    @Transactional
    int renameCourse(@Param("course") Course course, @Param("name") String name);
}
