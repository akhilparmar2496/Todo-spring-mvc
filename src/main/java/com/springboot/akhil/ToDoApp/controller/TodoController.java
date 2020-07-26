package com.springboot.akhil.ToDoApp.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.*;
import org.springframework.web.bind.WebDataBinder;
import com.springboot.akhil.ToDoApp.model.Todo;
import com.springboot.akhil.ToDoApp.service.TodoServiceInterface;
import com.springboot.akhil.ToDoApp.utility.Utility;

@Controller
public class TodoController {

	@Autowired
	TodoServiceInterface todoService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/todoList", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = Utility.getLoggedInUserName();
		model.put("todos", todoService.getTodosByUser(name));
		// model.put("todos", service.retrieveTodos(name));
		return "todoList";
	}



	@RequestMapping(value = "/addTodo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	@RequestMapping(value = "/deleteTodo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		todoService.deleteTodo(id);
		// service.deleteTodo(id);
		return "redirect:/todoList";
	}
	@RequestMapping(value = "/updateTodo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Todo todo = todoService.getTodoById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/updateTodo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUserName(Utility.getLoggedInUserName());
        todoService.updateTodo(todo);
        return "redirect:/todoList";
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUserName(Utility.getLoggedInUserName());
        todoService.saveTodo(todo);
        return "redirect:/todoList";
    }

	

}
