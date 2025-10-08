package com.example.todo.controller;

import com.example.todo.models.Todo;
import com.example.todo.services.TodoService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public String getTodos(Model model){
        List<Todo> todos=todoService.getAllTodos();   /// the service layer contains the logic of managing the data
        model.addAttribute("Todos",todos);
        return "Todos";
    }
}
