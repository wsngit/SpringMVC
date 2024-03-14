package ru.vlsu.ispi.kpp.SpringMVC;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.kpp.SpringMVC.model.course.Course;
import ru.vlsu.ispi.kpp.SpringMVC.service.CourseService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;

    @PostMapping("/course/add")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PatchMapping("/course/rename")
    public int renameCourse(@RequestParam long cid, @RequestParam String newName){
        return courseService.renameCourse(cid, newName);
    }

    @GetMapping("/courses")
    public List<Course> courses(){
        return courseService.courses();
    }

    @GetMapping("/group/{gid}/courses")
    public List<Course> coursesByGroupId(@PathVariable long gid){
        return courseService.coursesByGroupId(gid);
    }

    @GetMapping("/student/{sid}/courses")
    public List<Course> coursesByStudentId(@PathVariable long sid){
        return courseService.coursesByStudentId(sid);
    }
}
