package com.g3appdev.SYSLAB.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "teacher")
public class TeacherEntity {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private int id;

private String fname;

private String lname;

@OneToOne(mappedBy = "teacher")
private CourseEntity course;

public TeacherEntity() {

super();

}

public TeacherEntity(int id, String fname, String lname, CourseEntity course) {
super();
this.id = id;
this.fname = fname;
this.lname = lname;
this.course = course;
}

public void setId(int id) {
this.id = id;
}

public String getFname() {
return fname;
}

public void setFname(String fname) {

this.fname = fname;

}

public String getLname() {

return lname;

}

public void setLname(String lname) {

this.lname = lname;

}

public int getId() {
        return id;
    }

    
}