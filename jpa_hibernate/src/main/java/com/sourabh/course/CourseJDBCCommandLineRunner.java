package com.sourabh.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sourabh.course.jdbc.CourseJDBCRepository;

// CLR is for firing query at start of execution 
@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner
{
    @Autowired
    private CourseJDBCRepository repository;

    @Override
    public void run(String... args) throws Exception 
    {
       repository.insert(new Course(1, "Learn AWS" , "Sourabh"));
       repository.insert(new Course(2, "Learn Azure" , "Sourabh Shinde"));

       repository.deleteById(1);
    }
    
}
