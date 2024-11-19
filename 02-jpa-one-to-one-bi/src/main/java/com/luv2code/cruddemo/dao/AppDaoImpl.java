package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDao{

    // define the field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor=entityManager.find(Instructor.class,theId);

        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetails findDetailsById(int theId) {
        return entityManager.find(InstructorDetails.class,theId);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailsById(int theId) {
        InstructorDetails tempInstructorDetails= entityManager.find(InstructorDetails.class,theId);

        /* to break the linkage between instructor and instructor details bidirectional bond */
        tempInstructorDetails.getInstructor().setInstructorDetails(null);


        entityManager.remove(tempInstructorDetails);
    }
}
