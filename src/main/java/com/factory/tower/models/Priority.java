package com.factory.tower.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Priority {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;


    @OneToMany(mappedBy = "priority", cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Task> task;
}
