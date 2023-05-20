package com.sourabh.webapp01.ToDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

// All Logics

@Service
class ToDoService 
{
    private static List<ToDo> list_todos = new ArrayList<>();
    private static int todosCount = 0;
    static
    {
        list_todos.add(new ToDo(++todosCount, "sourabh", "Learn AWS", 
        LocalDate.now().plusYears(1), false));

        list_todos.add(new ToDo(++todosCount, "sourabh", "Learn DevOps", 
        LocalDate.now().plusDays(60), false));

        list_todos.add(new ToDo(++todosCount, "sourabh", "Learn Azure", 
        LocalDate.now().plusDays(100), false));
    }

    public List<ToDo> findByUserName(String username)
    {
        return list_todos;
    }

    
    public void addTodo(String username, String description, 
    LocalDate targetDate, boolean done)
    {
        // todo is class 
        // list_todos is list object to add in list 
        ToDo newtodo = new ToDo(++todosCount,username, description,targetDate,done);
        list_todos.add(newtodo);
        
    }

    public void deleteById(int id)
    {
        Predicate<? super ToDo> predicate = ToDo->ToDo.getId() == id;
        list_todos.removeIf(predicate);
    }


    public ToDo findById(int id) 
    {
        Predicate<? super ToDo> predicate = ToDo->ToDo.getId() == id;
        ToDo localTodo = list_todos.stream().filter(predicate).findFirst().get();
        return localTodo;
    }


    public void updateTodo(@Valid ToDo todoObj) 
    {
        deleteById(todoObj.getId());
        list_todos.add(todoObj);
    }


    


}
