package com.restfull_services.restapi_back.Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService
{
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "sourabh", "Learn FullStack",
                LocalDate.now().plusMonths(3), false));
        todos.add(new Todo(++todosCount, "sourabh", "Learn AWS",
                LocalDate.now().plusDays(40), false));
        todos.add(new Todo(++todosCount, "sourabh", "Learn DevOps",
                LocalDate.now().plusMonths(5), false));
            }

    public Todo addTodo(String username, String description, LocalDate date, boolean isdone)
    {
        Todo todoObj = new Todo(++todosCount,username,description,date,isdone);
        todos.add(todoObj);
        return todoObj;
    }

    public List<Todo> findByUsername(String username)
    {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void deleteById(int id)
    {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id)
    {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }


    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
