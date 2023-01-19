package com.hroddev.todoapi.mapper;

import com.hroddev.todoapi.persistence.entity.Task;
import com.hroddev.todoapi.persistence.entity.TaskStatus;
import com.hroddev.todoapi.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOtoTask implements IMapper<TaskInDTO, Task> {
    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();

        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setCreateDate(LocalDateTime.now());
        task.setEta(in.getEta());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }

    }
