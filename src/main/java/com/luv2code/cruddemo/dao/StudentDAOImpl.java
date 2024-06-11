package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{


    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection


    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
       entityManager.persist(student);
    }

    @Override
    //@Transaciton - no need to add in retrieval method
    public Student findById(Integer id) {
        return entityManager.find(Student.class, 1);
    }

    @Override
    //@Transactional - no need to add as only retriwving list from DB
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student s) {
        s.setEmail("update@gmail.com");
        entityManager.merge(s);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
       Student student = entityManager.find(Student.class, id);
        System.out.println("Record deleted:" +student.toString());
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));
    }
}
