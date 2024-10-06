package com.g3appdev.SYSLAB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.g3appdev.SYSLAB.Entity.CourseEntity;


@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {
public CourseEntity findByCourseId(int courseId);


}
