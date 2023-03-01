package com.factory.tower.services;

import com.factory.tower.dto.TaskRequest;
import com.factory.tower.models.Priority;
import com.factory.tower.models.Status;
import com.factory.tower.models.Task;
import com.factory.tower.repository.PriorityRepository;
import com.factory.tower.repository.StatusRepository;
import com.factory.tower.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StatusService statusService;

    @Autowired
    private PriorityService priorityService;

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task create(TaskRequest request){
        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setSubTask(request.getSubTask());
        task.setBeginDate(LocalDateTime.now());
        Status status = statusService.getOne(request.getStatusId());
        Priority priority = priorityService.getOne(request.getPriorityId());
        task.setStatus(status);
        task.setPriority(priority);
        return taskRepository.save(task);
    }

    public Task update(Integer id, TaskRequest request){
        Task task = taskRepository.findById(id).get();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        if (request.getEndDate()){
            task.setEndDate(LocalDateTime.now());
        }
        if (request.getStatusId() != null){
            task.setStatus(statusService.getOne(request.getStatusId()));
        }
        if (request.getPriorityId() != null){
            task.setPriority(priorityService.getOne(request.getPriorityId()));
        }


        return taskRepository.save(task);
    }

    public ResponseEntity<String> delete(Integer id){
        taskRepository.deleteById(id);
        return new ResponseEntity<>("Task deleted successful.", HttpStatus.OK);
    }

    public Task getOne(Integer id){
        return taskRepository.findById(id).get();

    }





}
