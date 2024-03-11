package ru.vlsu.ispi.kpp.SpringMVC.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.vlsu.ispi.kpp.SpringMVC.model.Group;
import ru.vlsu.ispi.kpp.SpringMVC.model.Student;
import ru.vlsu.ispi.kpp.SpringMVC.repo.GroupRepository;
import ru.vlsu.ispi.kpp.SpringMVC.repo.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentGroupService {
    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

    public Group addGroup(String gName){
        Group group = new Group(gName);
        group = groupRepository.save(group);
        return group;
    }

    public Optional<Group> groupById(long gid){
        return groupRepository.findById(gid);
    }
    public Optional<Group> groupByName(String name){
        return groupRepository.findByName(name);
    }

    public List<Student> getStudentsByGruopName(String name){
        Optional<Group> group = groupByName(name);
        if(group.isPresent())
            //return studentRepository.findAllByGroup(group.get());

            //Sorting results
            //return studentRepository.findAllByGroupOrderByIdDesc(group.get());
            //return studentRepository.findAllByGroupOrderByIdAsc(group.get());
            return studentRepository.findAllByGroup(
                    group.get(),
                    Sort.by(Sort.Direction.ASC, "id")
                            //.and(...)
            );
        else
            return new ArrayList<>();
    }

    public List<Student> getStudentsByGruopID(long gid){
        Optional<Group> group = groupById(gid);
        if(group.isPresent())
            return studentRepository.findAllByGroup(group.get());
        else
            return new ArrayList<>();
    }

    public Student addStudent(long gid, Student student){
        Optional<Group> group = groupById(gid);
        checkOptional(group,  "group not found");
        student.setGroup(group.get());
        studentRepository.save(student);
        return student;
    }

    public List<Student> allStudents(int page, int pageSize){
        Page<Student> studentPage = studentRepository.findAll(
                PageRequest.of(page, pageSize,
                        Sort.by(Sort.Direction.ASC, "id")
                )
        );
        return studentPage.getContent();
    }

    public static void checkOptional(Optional obj, String message){
        if(obj.isEmpty()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, message
        );
    }
}