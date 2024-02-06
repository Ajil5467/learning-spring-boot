package com.ajil.cruddemo.dao;

import com.ajil.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);



    Student findById(Integer Id);


    List<Student> findAll();


    void update(Student theStudent);

    void delete(Integer id);
}
