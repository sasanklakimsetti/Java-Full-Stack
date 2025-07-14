package com.summerpep.todo.service;

import com.summerpep.todo.model.ToDo;

import java.util.List;

public interface ToDoService {
    ToDo addToDo(ToDo toDo);
    ToDo updateToDo(ToDo toDo);
    public List<ToDo>findAllByUsername(String username);
}
