package com.quest.springbootrest.services;

import com.quest.springbootrest.dao.CourseDao;
import com.quest.springbootrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
//    List<Course> list;

    public CourseServiceImpl() {

//        this.list = new ArrayList<>();
//        list.add(new Course(123, "Java", "Elementary"));
//        list.add(new Course(124, "Java springboot", "Elementary"));
    }

    @Override
    public List<Course> getCourses() {
//        return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourses(long courseId) {
//        for(Course c:list) {
//            if(c.getId()==courseId)
//                return c;
//        }
//        return null;
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
//        return course;
        return courseDao.save(course);

    }

    @Override
    public Course updateCourse(Course course) {
//        list.forEach( c -> {
//            if(c.getId() == course.getId()){
//                c.setTitle(course.getTitle());
//                c.setDescription(course.getDescription());
//            }
//        });
//        return course;
        return courseDao.save(course);
    }

    @Override
    public void deleteCourse(long courseId) {
//        list  = list.stream().filter(course -> course.getId()!=courseId).collect(Collectors.toList());
        Course course = courseDao.getOne(courseId);
        courseDao.delete(course);
    }

}
