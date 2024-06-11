package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public void updateStudent(Student student);

    public void deleteStudent(Integer id);
}
