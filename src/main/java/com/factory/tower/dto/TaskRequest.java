package com.factory.tower.dto;

import lombok.Data;

@Data
public class TaskRequest {
    private Integer statusId;
    private Integer priorityId;
    private Integer subTask;
    private String name;
    private String description;
    private Boolean endDate;


}
