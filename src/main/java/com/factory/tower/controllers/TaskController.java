package com.factory.tower.controllers;

import com.factory.tower.dto.TaskRequest;
import com.factory.tower.dto.TaskResponse;
import com.factory.tower.models.Task;
import com.factory.tower.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll(){
        List<Task> tasks =   taskService.getAll();

        List<TaskResponse> storeResponses = new ArrayList<>();
        for (Task store: tasks) {
            if (store.getSubTask() == null){
                TaskResponse response = new TaskResponse();
                response.setId(store.getId());
                response.setName(store.getName());
                response.setDescription(store.getDescription());
                response.setBeginDate(store.getBeginDate());
                response.setEndDate(store.getEndDate());
                response.setStatus(store.getStatus());
                response.setPriority(store.getPriority());

                List<Task> taskResponses = new ArrayList<>();
                for (Task task: tasks) {
                    if (task.getSubTask() == store.getId()){
                        taskResponses.add(task);
                    }
                }
                response.setSubtasks(taskResponses);
                storeResponses.add(response);
            }
        }
        return new ResponseEntity<>(storeResponses, HttpStatus.OK);



    }
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody TaskRequest taskRequest){
        taskService.create(taskRequest);

        return new ResponseEntity<>("Task created successful.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody TaskRequest taskRequest, @PathVariable Integer id){
        taskService.update(id, taskRequest);
        return new ResponseEntity<>("Task updated successful.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        return taskService.delete(id);
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Integer id){
        return taskService.getOne(id);

    }

    @PostMapping("/{id}/subtask")
    public ResponseEntity<Object>  createSubtask(@RequestBody TaskRequest taskRequest, @PathVariable Integer id){
        taskRequest.setSubTask(id);
        taskService.create(taskRequest);
        return new ResponseEntity<>("SubTask created successful.", HttpStatus.OK);
    }
}
