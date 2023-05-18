package com.sourabh.webapp01.ToDo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        List<ToDo> todos = todoservice.findByUserName("sourabh");
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    // GET POST
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model)
    {
        String username =(String)model.get("name");
        ToDo todo = new ToDo(0, username, "Default", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    // @ModelAttribute("todoObj")
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@Valid ToDo todoObj,ModelMap model, BindingResult result)
    {
        // @ModelAttribute("todoObj")
        // boolean error = result.hasErrors();
        if(result.hasErrors())
        {
            
            return "todo"; 
        }

        String username = (String)model.get("name");
        todoservice.addTodo(username, todoObj.getDescription(), 
        LocalDate.now().plusMonths(10), false);

        return "redirect:list-todos";
    }

}