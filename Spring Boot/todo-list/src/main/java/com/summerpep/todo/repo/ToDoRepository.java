package com.summerpep.todo.repo;

import com.summerpep.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {  // In the table ToDo, Integer is the datatype of primary key
    @Query("select t from ToDo t where t.user.username= :username")
    List<ToDo> findByUsername(String username);
}
