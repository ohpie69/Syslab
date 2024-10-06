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
import com.g3appdev.SYSLAB.Entity.TeacherEntity;
import com.g3appdev.SYSLAB.TeacherService.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping(method = RequestMethod.GET,path="/api/teacher")

public class TeacherController {

@Autowired

TeacherService tserv;

@GetMapping("/print")

public String print() {

return "Hello, Firstname Lastname";

}

//Create of CRUD

@PostMapping("/postteacherrecord")

public TeacherEntity postTeacherRecord(@RequestBody TeacherEntity teacher) {

return tserv.postTeacherRecord(teacher);

}

//Read of CRUD

@GetMapping("/getAllTeachers")

public List<TeacherEntity> getAllTeachers(){

return tserv.getAllTeachers();

}

// Update of CRUD
@PutMapping("/updateteacher/{id}")
public TeacherEntity updateTeacher(@PathVariable int id, @RequestBody TeacherEntity teacher) {
    return tserv.updateTeacher(id, teacher);
}

// Delete of CRUD
@DeleteMapping("/deleteteacher/{id}")
public String deleteTeacher(@PathVariable int id) {
    return tserv.deleteTeacher(id);
}
}