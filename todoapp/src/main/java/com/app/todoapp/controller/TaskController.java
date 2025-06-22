package com.app.todoapp.controller;

import com.app.todoapp.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTasks(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
