package com.quest.springbootrest.services;

import com.quest.springbootrest.entities.Course;
import java.util.List;

public interface CourseService {
    List<Course> getCourses();

    Course getCourses(long courseId);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(long courseId);
}
