package com.summerpep.todo.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int todoid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    User user;

    private String description;

    @Column(name = "tododate")
    private Date todoDate;
    private boolean completed;

    public ToDo() {

    }

    public int getTodoid() {
        return todoid;
    }

    public void setTodoid(int todoid) {
        this.todoid = todoid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "todoid=" + todoid +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", todoDate=" + todoDate +
                ", completed=" + completed +
                '}';
    }

    public ToDo(User user, String description, Date todoDate, boolean completed) {
        this.user = user;
        this.description = description;
        this.todoDate = todoDate;
        this.completed = completed;
    }
}
