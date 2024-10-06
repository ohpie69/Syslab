package com.g3appdev.SYSLAB.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g3appdev.SYSLAB.Repository.TeacherRepo;
import com.g3appdev.SYSLAB.Entity.TeacherEntity;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class TeacherService {

    @Autowired

    TeacherRepo teacherRepo;

    public TeacherService() {

    super();

    // TODO Auto-generated constructor stub

    }

    //Create of CRUD

    public TeacherEntity postTeacherRecord(TeacherEntity teacher) {

    return teacherRepo.save(teacher);

    }

    //Read of CRUD

    public List<TeacherEntity> getAllTeachers() {

    return teacherRepo.findAll();

    }

    // Update of CRUD
    public TeacherEntity updateTeacher(int teacherId, TeacherEntity newTeacherDetails) {
        TeacherEntity teacher = new TeacherEntity();
        try {
            teacher = teacherRepo.findById(teacherId).get();

            // 2. update the record
            teacher.setFname(newTeacherDetails.getFname());
            teacher.setLname(newTeacherDetails.getLname());
            
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("Teacher " + teacherId + " does not exist!");
        }
        return teacherRepo.save(teacher);
    }

    // Delete of CRUD
    public String deleteTeacher(int teacherId) {
        Optional<TeacherEntity> optionalTeacher = teacherRepo.findById(teacherId);

        if (optionalTeacher.isPresent()) {
            teacherRepo.deleteById(teacherId);
            return "Teacher " + teacherId + " is successfully deleted!";
        } else {
            return "Teacher " + teacherId + " does not exist.";
        }
    }
}