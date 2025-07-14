package com.summerpep.todo.repo;

import com.summerpep.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {  // In the user table, String is the datatype of primary key

}
