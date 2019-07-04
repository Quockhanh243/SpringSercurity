package com.example.springSercurity.service;

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

    String [] messenger = {"Get all Student From DB",
            "Find all Student From DB by name %s\n",
            "Student has been create",
            "Student has been deleted",
            "Student not found",
            "Updating Student with ID = %d\n",
            "Student has been updated"
    };

    public List<Student> getStudentFormDB(){
        System.out.println(messenger[0]);
        List<Student> students = new ArrayList<>();
        studentReponsitory.findAll().forEach(students::add);
        return students;
    }

    public List<Student> findByName(String name){
        System.out.printf(messenger[1],name);
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
        return new ResponseEntity<>(messenger[2], HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(int id){
        studentReponsitory.findById(id).map(
                student -> {
                    studentReponsitory.deleteById(id);
                    return 0;
                }
        ).orElseThrow(()-> new ResourceNotFoundException(messenger[4]));
        return new ResponseEntity<>(messenger[3], HttpStatus.OK);
    }

    public ResponseEntity<String> updateStudent(int id, Student studentData){
        System.out.printf(messenger[5],id);
        studentReponsitory.findById(id).map(
                student -> {
                    student.setId(studentData.getId());
                    student.setName(studentData.getName());
                    return studentReponsitory.save(student);
                }
        ).orElseThrow(() -> new ResourceNotFoundException(messenger[4]));
        return new ResponseEntity<>(messenger[6], HttpStatus.OK);
    }
}
