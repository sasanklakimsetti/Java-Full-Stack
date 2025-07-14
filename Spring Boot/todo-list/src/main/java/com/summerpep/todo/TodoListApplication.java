package com.summerpep.todo;

import com.summerpep.todo.model.ToDo;
import com.summerpep.todo.model.User;
import com.summerpep.todo.service.ToDoService;
import com.summerpep.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class TodoListApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	public static void add(UserService userService, ToDoService toDoService) {
		User user = new User("sasank", "ssnk123", true);

		if (userService.findUsername(user.getUsername()) == null) {
			userService.addUser(user);
		}

		User existingUser = userService.findUsername(user.getUsername());
		if (existingUser != null && existingUser.isEnabled()) {
			ToDo todo = new ToDo(existingUser, "Complete two cans", Date.valueOf("2025-07-14"), false);
			toDoService.addToDo(todo);
			System.out.println("✅ ToDo added for user: " + existingUser.getUsername());
		}
	}
}
