package com.summerpep.todo.service;

import com.summerpep.todo.model.ToDo;
import com.summerpep.todo.repo.ToDoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    @Override
    @Transactional
    public ToDo addToDo(ToDo toDo) {
        ToDo saved=toDoRepository.save(toDo);
        return saved;
    }

    @Override
    @Transactional
    public ToDo updateToDo(ToDo toDo) {
        ToDo updated=toDoRepository.save(toDo);
        return updated;
    }

    @Transactional
    public List<ToDo>findAllByUsername(String username){
        return toDoRepository.findByUsername(username);
    }
}
