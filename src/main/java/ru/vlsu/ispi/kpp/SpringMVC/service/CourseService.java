package ru.vlsu.ispi.kpp.SpringMVC.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vlsu.ispi.kpp.SpringMVC.model.Course;
import ru.vlsu.ispi.kpp.SpringMVC.model.Group;
import ru.vlsu.ispi.kpp.SpringMVC.model.Student;
import ru.vlsu.ispi.kpp.SpringMVC.repo.CourseRepository;
import ru.vlsu.ispi.kpp.SpringMVC.repo.GroupRepository;
import ru.vlsu.ispi.kpp.SpringMVC.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

import static ru.vlsu.ispi.kpp.SpringMVC.service.StudentGroupService.checkOptional;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;
    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> courses(){
        return courseRepository.findAll();
    }

    public List<Course> coursesByGroupId(long gid){
        Optional<Group> group = groupRepository.findById(gid);
        checkOptional(group,  "group not found");
        return courseRepository.findAllByGroup(group.get());
    }

    public List<Course> coursesByStudentId(long sid){
        Optional<Student> student = studentRepository.findById(sid);
        checkOptional(student,  "student not found");
        return courseRepository.findAllByStudent(student.get());
    }

    public int  renameCourse(long cid, String name){
        Optional<Course> course = courseRepository.findById(cid);
        checkOptional(course,  "course not found");
        return courseRepository.renameCourse(course.get(), name);
    }
}
