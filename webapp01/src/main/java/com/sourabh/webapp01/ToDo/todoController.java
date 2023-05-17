package com.sourabh.webapp01.ToDo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class todoController 
{
    private todoService todoservice;
    

    public todoController(todoService todoservice) {
        this.todoservice = todoservice;
    }


    @RequestMapping("list-todos")
    public String listAllTodoString(ModelMap model)
    {
        List<todo> todos = todoservice.findByUserName("sourabh");
        model.addAttribute("todos", todos);

        return "listTodos";
    }
}
