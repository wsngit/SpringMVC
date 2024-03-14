package ru.vlsu.ispi.kpp.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.kpp.SpringMVC.model.student.Group;
import ru.vlsu.ispi.kpp.SpringMVC.model.student.Student;
import ru.vlsu.ispi.kpp.SpringMVC.service.StudentGroupService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserGroupController {

    @Autowired
    private StudentGroupService studentGroupService;

    @GetMapping("/groups")
    public List<Group> getGroups(){
        return studentGroupService.getGroups();
    }

    @PostMapping("/group/add")
    public Group newGroup(@RequestBody Group group){
        return studentGroupService.addGroup(group.getName());
    }

    @GetMapping("/group/{gid}")
    public Group newGroup(@PathVariable long gid){
        Optional<Group> group = studentGroupService.groupById(gid);
        StudentGroupService.checkOptional(group,  "group not found");
        return group.get();
    }

    @GetMapping("/group")
    public Group newGroup(@RequestParam String gname){
        Optional<Group> group = studentGroupService.groupByName(gname);
        StudentGroupService.checkOptional(group,  "group not found");
        return group.get();
    }

    @GetMapping("/group/byName")
    public List<Student> studentsByGroupName(@RequestParam String gname){
        return studentGroupService.getStudentsByGruopName(gname);
    }

    @GetMapping("/group/{gid}/students")
    public List<Student> studentsByGroupName(@PathVariable long gid){
        return studentGroupService.getStudentsByGruopID(gid);
    }

    @PostMapping("/group/{gid}/addStudent")
    public Student addStudent(@PathVariable long gid, @RequestBody Student student){
        return studentGroupService.addStudent(gid, student);
    }

    @GetMapping("/students")
    public List<Student> students(@RequestParam int page, @RequestParam int pageSize){
        return studentGroupService.allStudents(page, pageSize);
    }
}
