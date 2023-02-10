package com.hroddev.todoapi.controller;

import com.hroddev.todoapi.persistence.entity.Task;
import com.hroddev.todoapi.persistence.entity.TaskStatus;
import com.hroddev.todoapi.service.TaskService;
import com.hroddev.todoapi.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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

    @PatchMapping("/markasfinished/{id}")
    public ResponseEntity<Void> markFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
