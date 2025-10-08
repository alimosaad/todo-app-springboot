package com.example.todo.controller;

import com.example.todo.models.Todo;
import com.example.todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public String getTodos(Model model){
        List<Todo> todos=todoService.getAllTodos();   /// the service layer contains the logic of managing the data
        model.addAttribute("todos",todos);
        return "Todo";
    }
    @PostMapping("/todo")
    public String CreateTodo(@RequestParam String title){
        todoService.createTodo(title);   /// the service layer contains the logic of managing the data
        return "redirect:/todo";
    }
    @GetMapping("/todo/{id}/delete")
    public String DeleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);   /// the service layer contains the logic of managing the data
        return "redirect:/todo";
    }

    @GetMapping("/todo/{id}/toggle")
    public String ToggleTodo(@PathVariable Long id){
        todoService.toggleTodo(id);   /// the service layer contains the logic of managing the data
        return "redirect:/todo";
    }
}
