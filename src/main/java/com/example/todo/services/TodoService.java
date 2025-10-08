package com.example.todo.services;

import com.example.todo.models.Todo;
import com.example.todo.reporitory.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {

        return todoRepository.findAll();
    }
}
