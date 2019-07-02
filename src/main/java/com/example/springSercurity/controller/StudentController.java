package com.example.springSercurity.controller;

import com.example.springSercurity.entity.Student;
import com.example.springSercurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public List<Student> getAll(){
        return studentService.getStudentFormDB();
    }

    @GetMapping("/{name}")
    public List<Student> findStudentsByName(@PathVariable("name") String name){
        return studentService.findByName(name);
    }
    @GetMapping("/find/{name}")
    public Student findStudentByName(@PathVariable("name") String name){
        return studentService.findOneByName(name);
    }
}
