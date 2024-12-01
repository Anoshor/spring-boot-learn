package com.Anoshor.trycrud.dao;

import com.Anoshor.trycrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    //define field for entity manager
    private EntityManager eM;

    //inject em using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager eM) {
        this.eM = eM;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student s) {
        eM.persist(s);
    }

    @Override
    public Student findById(Integer Id) {
        return eM.find(Student.class, Id);
    }

    @Override
    public List<Student> findAll() {

        //create query
        TypedQuery<Student> q = eM.createQuery("from Student order by firstName", Student.class);

        //return query results
        return q.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lname) {

        TypedQuery<Student> q = eM.createQuery("from Student where lastName=:temp", Student.class);
        q.setParameter("temp", lname);
        return q.getResultList();
    }

    @Override
    @Transactional
    public void update(Student s) {
        eM.merge(s);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student s = eM.find(Student.class, id);
        if (s == null) {
            // Handle the case where the student is not found
            System.err.println("Error: Student with id " + id + " not found.");
            return;
        }
        eM.remove(s);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = eM.createQuery("delete from Student").executeUpdate();

        return rowsDeleted;
    }
}
