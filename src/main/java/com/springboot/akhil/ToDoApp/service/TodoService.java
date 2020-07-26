package com.springboot.akhil.ToDoApp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.akhil.ToDoApp.model.Todo;
import com.springboot.akhil.ToDoApp.model.Enum.Status;
import com.springboot.akhil.ToDoApp.repository.TodoRepository;

@Service
public class TodoService  implements TodoServiceInterface {
	
	@Autowired
	TodoRepository todoRepository;

	public List<Todo> getTodosByUser(String user) {
		// TODO Auto-generated method stub
		return todoRepository.findByUserName(user);
	}

	public Optional<Todo> getTodoById(long id) {
		// TODO Auto-generated method stub
		return todoRepository.findById(id);
	}

	public void updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		todoRepository.save(todo);
		
	}

	public void addTodo(String name, String desc, Date startDate,
			Date endDate, Status status, boolean isDone) {
		// TODO Auto-generated method stub
		todoRepository.save(new Todo(name, desc, startDate, endDate, status));
		
	}

	public void deleteTodo(long id) {
		// TODO Auto-generated method stub
		todoRepository.deleteById(id);
		
	}

	public void saveTodo(Todo todo) {
		// TODO Auto-generated method stub
		todoRepository.save(todo);
		
	}

}
