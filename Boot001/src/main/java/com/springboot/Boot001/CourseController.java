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
    
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses()
    {
        return Arrays.asList(new Course(1, "AWS Cloud 001", "Sourabh"),
        new Course(2, "Learn DevOps", "Shubham"),
        new Course(3, "Java Spring Boot", "Vishal")  
        );
    }
}
