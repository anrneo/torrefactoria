package com.factory.tower.services;

import com.factory.tower.dto.TaskRequest;
import com.factory.tower.models.Priority;
import com.factory.tower.models.Status;
import com.factory.tower.models.Task;
import com.factory.tower.repository.PriorityRepository;
import com.factory.tower.repository.StatusRepository;
import com.factory.tower.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    @Autowired
    private PriorityRepository priorityRepository;
    @Autowired
    private TaskRepository taskRepository;
    public List<Priority> getAll(){
        return priorityRepository.findAll();
    }

    public Priority create(Priority priority){

        return priorityRepository.save(priority);
    }

    public Priority update(Integer id, Priority request){
        Priority priority = priorityRepository.getById(id);
        priority.setName(request.getName());
        priority.setDescription(request.getDescription());
        return priorityRepository.save(priority);
    }

    public ResponseEntity<Object> delete(Integer id){
        priorityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Priority getOne(Integer id){
        return priorityRepository.getById(id);

    }
}
