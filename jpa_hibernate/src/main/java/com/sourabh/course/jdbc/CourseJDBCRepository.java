package com.sourabh.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.sourabh.course.Course;

@Repository
public class CourseJDBCRepository 
{
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String insert_query = """ 
        insert into course (id, name, author) values(?, ? , ?);
        """;
        
    private static String delete_query = """ 
        delete from course where id = ? 
        """;
    
    public void insert(Course c)
    {
        springJdbcTemplate.update(insert_query,
         c.getId(), c.getName(), c.getAuthor());
    }

    public void deleteById(long id)
    {
        springJdbcTemplate.update(delete_query, id);
    }

}
