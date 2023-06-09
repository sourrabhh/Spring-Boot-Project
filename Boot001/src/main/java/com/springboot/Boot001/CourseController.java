package com.springboot.Boot001;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController   // Return back 
public class CourseController 
{
    // Courses
    // Courses:: ID, Name, Author
    
    @RequestMapping("/course")
    public List<Course> retrieveAllCourses()
    {
        return Arrays.asList(new Course(001, "AWS Cloud 001", "Sourabh Shinde"),
        new Course(02, "Learn DevOps", "Shubham"),
        new Course(03, "Java Spring Boot", "Vishal"),
        new Course(04, "Learn Azure", "Vijay")
        );
    }
}
