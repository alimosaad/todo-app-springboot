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

    public void createTodo(String title) {

        Todo todo=new Todo();
        todo.setTitle(title);
        todo.setCompleted(false); /// false by default and later we change to true for isCompleted
        todoRepository.save(todo);

    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public void toggleTodo(Long id) {
        Todo todo=todoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid Todo Id"));
        todo.setCompleted(!todo.isCompleted());
        todoRepository.save(todo);
    }
}
