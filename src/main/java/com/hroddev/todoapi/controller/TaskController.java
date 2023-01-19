package com.hroddev.todoapi.controller;

import com.hroddev.todoapi.persistence.entity.Task;
import com.hroddev.todoapi.persistence.entity.TaskStatus;
import com.hroddev.todoapi.service.TaskService;
import com.hroddev.todoapi.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.findAllByStatusMethod(status);
    }

}
