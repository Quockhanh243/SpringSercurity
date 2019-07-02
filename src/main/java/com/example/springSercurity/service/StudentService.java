package com.example.springSercurity.service;

import com.example.springSercurity.entity.Student;
import com.example.springSercurity.reponsitory.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentReponsitory studentReponsitory;

    public List<Student> getStudentFormDB(){
        System.out.println("Get all Student From DB");
        List<Student> students = new ArrayList<>();
        studentReponsitory.findAll().forEach(students::add);
        return students;
    }

    public List<Student> findByName(String name){
        System.out.println("Find all Student From DB by name");
        List<Student> students = new ArrayList<>();
        studentReponsitory.findStudentsByName(name).forEach(students::add);
        return students;
    }

    public Student findOneByName(String name) {
        System.out.println("Find Student by name");
        return studentReponsitory.findStudentByName(name);
    }
}
