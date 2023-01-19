package com.hroddev.todoapi.service;

import com.hroddev.todoapi.mapper.TaskInDTOtoTask;
import com.hroddev.todoapi.persistence.entity.Task;
import com.hroddev.todoapi.persistence.entity.TaskStatus;
import com.hroddev.todoapi.persistence.repository.TaskRepository;
import com.hroddev.todoapi.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOtoTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOtoTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByStatusMethod(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }
}
