package com.factory.tower.controllers;

import com.factory.tower.models.Status;
import com.factory.tower.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAll(){
        return  statusService.getAll();



    }
    @PostMapping
    public Status create(@RequestBody Status status){
        return statusService.create(status);


    }

    @PutMapping("/{id}")
    public Status update(@RequestBody Status status, @PathVariable Integer id){
        return statusService.update(id, status);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        statusService.delete(id);
        return new ResponseEntity<>("Status deleted successful.", HttpStatus.OK);
    }


}
