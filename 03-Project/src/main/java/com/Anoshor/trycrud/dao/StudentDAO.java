package com.Anoshor.trycrud.dao;

import com.Anoshor.trycrud.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface StudentDAO {

    void save(Student s);
    Student findById(Integer Id);

    List<Student> findAll();
    List<Student> findByLastName(String lname);

    void update(Student s);
    void delete(Integer id);
    int deleteAll();
}
