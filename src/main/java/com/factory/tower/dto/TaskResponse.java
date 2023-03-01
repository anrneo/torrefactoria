package com.factory.tower.dto;

import com.factory.tower.models.Priority;
import com.factory.tower.models.Status;
import com.factory.tower.models.Task;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskResponse {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private List<Task> subtasks;
    private Status status;
    private Priority priority;
    private int duration;


}
