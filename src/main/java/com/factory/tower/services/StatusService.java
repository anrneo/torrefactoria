package com.factory.tower.services;

import com.factory.tower.dto.TaskRequest;
import com.factory.tower.models.Status;
import com.factory.tower.models.Task;
import com.factory.tower.repository.StatusRepository;
import com.factory.tower.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAll(){
        return statusRepository.findAll();
    }

    public Status create(Status status){

        return statusRepository.save(status);
    }

    public Status update(Integer id, Status request){
        Status status = statusRepository.getById(id);
        status.setName(request.getName());
        status.setDescription(request.getDescription());
        return statusRepository.save(status);
    }

    public ResponseEntity<Object> delete(Integer id){
        statusRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Status getOne(Integer id){
        return statusRepository.getById(id);

    }
}
