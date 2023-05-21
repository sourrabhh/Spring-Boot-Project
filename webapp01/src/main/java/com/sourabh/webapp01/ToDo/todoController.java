package com.sourabh.webapp01.ToDo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
class ToDoController 
{
    private ToDoService todoservice;
    

    public ToDoController(ToDoService todoservice) {
        this.todoservice = todoservice;
    }

    

    @RequestMapping("list-todos")
    public String listAllTodoString(ModelMap model)
    {
        String username = getLoggedInUserName(model);
        List<ToDo> todos = todoservice.findByUserName(username);
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    
    // GET POST
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model)
    {
        String username =getLoggedInUserName(model);
        ToDo todo = new ToDo(0, username, "Learn FullStack Development", LocalDate.now(), false);
        model.put("todo", todo);
        return "todo";
    }
   
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid ToDo todo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "todo"; //jsp file
        }

        String username = getLoggedInUserName(model);
        todoservice.addTodo(username, todo.getDescription(), 
        todo.getTargetDate(), false);

        return "redirect:list-todos";
    }

    // Delete ToDO 
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
        
        todoservice.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model)
    {
        ToDo todo = todoservice.findById(id);
        model.addAttribute("todo", todo);
        return "todo"; //jsp page
    }
    //

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid ToDo todoObj, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "todo"; 
        }

        String username = getLoggedInUserName(model);
        todoObj.setUserName(username);
        todoservice.updateTodo(todoObj);

        return "redirect:list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
         Authentication authentication =
         SecurityContextHolder.getContext().getAuthentication();
        
        return authentication.getName();
    }

}