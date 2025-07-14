package com.summerpep.todo.service;

import com.summerpep.todo.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {
    ToDo addToDo(ToDo toDo);
    ToDo updateToDo(ToDo toDo);
    public List<ToDo>findAllByUsername(String username);
}
