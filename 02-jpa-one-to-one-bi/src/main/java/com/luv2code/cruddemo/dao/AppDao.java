package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetails;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteInstructorById(int theId);
    InstructorDetails findDetailsById(int theId);
    void deleteInstructorDetailsById(int theId);
}
