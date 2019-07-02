package com.example.springSercurity.reponsitory;

import com.example.springSercurity.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentReponsitory extends MongoRepository<Student, Integer> {
    @Query("{name: '?0'}")
    List<Student> findStudentsByName(String name);

    @Query("{name: '?0'}")
    Student findStudentByName(String name);
}
