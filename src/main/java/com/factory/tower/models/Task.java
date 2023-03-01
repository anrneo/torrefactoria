package com.factory.tower.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer subTask;
    private String name;
    private String description;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name="priority_id", referencedColumnName = "id")
    private Priority priority;


    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName = "id")
    private Status status;
}
