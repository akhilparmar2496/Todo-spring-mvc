package com.springboot.akhil.ToDoApp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.springboot.akhil.ToDoApp.model.Todo;
import com.springboot.akhil.ToDoApp.model.Enum.Status;

public interface TodoServiceInterface {

	List<Todo> getTodosByUser(String user);

	Optional<Todo> getTodoById(long id);

	void updateTodo(Todo todo);

	void addTodo(String name, String desc,Date startDate, Date endDate,Status status, boolean isDone);

	void deleteTodo(long id);

	void saveTodo(Todo todo);

}
