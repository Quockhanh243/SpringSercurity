package com.example.springSercurity.service;

import com.example.springSercurity.config.JavaContains;
import com.example.springSercurity.entity.Student;
import com.example.springSercurity.reponsitory.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService {
    @Autowired
    StudentReponsitory studentReponsitory;

    public List<Student> getStudentFormDB(){
        System.out.println(JavaContains.GETALL);
        List<Student> students = new ArrayList<>();
        studentReponsitory.findAll().forEach(students::add);
        return students;
    }

    public List<Student> findByName(String name){
        System.out.printf(JavaContains.GETALLBYNAME,name);
        List<Student> students = new ArrayList<>();
        studentReponsitory.findStudentsByName(name).forEach(students::add);
        return students;
    }

//    public Student findOneByName(String name) {
//        System.out.println("Find Student by name");
//        return studentReponsitory.findStudentByName(name);
//    }

    public ResponseEntity<String> createStudent(Student student) {
        studentReponsitory.save(student);
        return new ResponseEntity<>(JavaContains.STUDENTCREATE, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(int id){
        studentReponsitory.findById(id).map(
                student -> {
                    studentReponsitory.deleteById(id);
                    return 0;
                }
        ).orElseThrow(()-> new ResourceNotFoundException(JavaContains.STUDENTNOTFOUND));
        return new ResponseEntity<>(JavaContains.STUDENTDELETE, HttpStatus.OK);
    }

    public ResponseEntity<String> updateStudent(int id, Student studentData){
        System.out.printf(JavaContains.STUDENTUPDATEID,id);
        studentReponsitory.findById(id).map(
                student -> {
                    student.setId(studentData.getId());
                    student.setName(studentData.getName());
                    return studentReponsitory.save(student);
                }
        ).orElseThrow(() -> new ResourceNotFoundException(JavaContains.STUDENTNOTFOUND));
        return new ResponseEntity<>(JavaContains.STUDENTUPDATE, HttpStatus.OK);
    }
}
