package com.g3appdev.SYSLAB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.g3appdev.SYSLAB.Entity.TeacherEntity;




@Repository

public interface TeacherRepo extends JpaRepository<TeacherEntity, Integer>{

//this is user-defined method to search a student record by lastname

public TeacherEntity findByFname(String fname);

//you may define more methods for searching, for instance, in this interface

}
