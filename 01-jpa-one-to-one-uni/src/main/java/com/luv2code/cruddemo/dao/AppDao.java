package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Entity.Instructor;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteInstructorById(int theId);
}
