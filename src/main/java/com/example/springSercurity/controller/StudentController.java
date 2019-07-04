package com.example.springSercurity.controller;

import com.example.springSercurity.entity.Student;
import com.example.springSercurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("")
    public List<Student> getAll(){
        return studentService.getStudentFormDB();
    }

    @GetMapping("/{name}")
    public List<Student> findStudentsByName(@PathVariable("name") String name){
        return studentService.findByName(name);
    }
//    @GetMapping("/find/{name}")
//    public Student findStudentByName(@PathVariable("name") String name){
//        return studentService.findOneByName(name);
//    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
       return studentService.createStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        return studentService.deleteStudent(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }
}
