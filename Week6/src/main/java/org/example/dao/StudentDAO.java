package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.entity.Student;

import java.util.List;

public class StudentDAO {

    private final EntityManagerFactory emf;

    private final EntityManager em;

    public StudentDAO() {
        emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
    }

    public Student getStudents() {
        Student student =  em.find(Student.class, Long.valueOf(1));
        return student;
    }

}
