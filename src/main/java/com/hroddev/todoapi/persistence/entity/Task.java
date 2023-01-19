package com.hroddev.todoapi.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TASK")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
