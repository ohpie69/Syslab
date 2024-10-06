package com.g3appdev.SYSLAB.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.g3appdev.SYSLAB.Entity.CourseEntity; 
import com.g3appdev.SYSLAB.TeacherService.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(method = RequestMethod.GET,path="/api/course")

public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getallcourses")
    public List<CourseEntity> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/createcourse")
    public CourseEntity createCourse(@RequestBody CourseEntity course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/updatecourse/{courseId}")
    public CourseEntity updateCourse(@PathVariable int courseId, @RequestBody CourseEntity courseDetails) {
        return courseService.updateCourse(courseId, courseDetails);
    }

    @DeleteMapping("/deletecourse/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        return courseService.deleteCourse(courseId);
    }
    
}
