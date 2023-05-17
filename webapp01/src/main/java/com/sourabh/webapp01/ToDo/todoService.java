package com.sourabh.webapp01.ToDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class todoService 
{
    private static List<todo> todos = new ArrayList<>();

    static
    {
        todos.add(new todo(1, "sourabh", "Learn AWS", 
        LocalDate.now().plusYears(1), false));

        todos.add(new todo(2, "sourabh", "Learn DevOps", 
        LocalDate.now().plusDays(60), false));

        todos.add(new todo(3, "sourabh", "Learn Azure", 
        LocalDate.now().plusDays(100), false));
    }

    public List<todo> findByUserName(String username)
    {
        return todos;
    }
}
