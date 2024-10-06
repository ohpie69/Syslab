package com.g3appdev.SYSLAB.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g3appdev.SYSLAB.Repository.CourseRepo;
import com.g3appdev.SYSLAB.Entity.CourseEntity;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    //Create of CRUD
    public CourseEntity createCourse(CourseEntity course) {
        return courseRepo.save(course);
    }

    //Read of CRUD
    public List<CourseEntity> getAllCourses() {
        return courseRepo.findAll();
    }

    //Update of CRUD
    public CourseEntity updateCourse(int courseId, CourseEntity courseDetails) {
        CourseEntity course = courseRepo.findByCourseId(courseId);
        if (course == null) {
            throw new NoSuchElementException("Course not found");
        }
        course.setDescription(courseDetails.getDescription());
        return courseRepo.save(course);
    }

    //Delete of CRUD
    public String deleteCourse(int courseId) {
        Optional<CourseEntity> optionalCourse = courseRepo.findById(courseId);

    if (optionalCourse.isPresent()) {
        courseRepo.deleteById(courseId);
        return "Course " + courseId + " is successfully deleted!";
    } else {
        return "Course " + courseId + " does not exist.";
    }
}

}
