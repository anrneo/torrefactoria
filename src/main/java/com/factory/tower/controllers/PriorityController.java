package com.factory.tower.controllers;


import com.factory.tower.models.Priority;
import com.factory.tower.services.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/priority")
public class PriorityController {

    @Autowired
    private PriorityService priorityService;

    @GetMapping
    public List<Priority> getAll(){
        return  priorityService.getAll();



    }
    @PostMapping
    public Priority create(@RequestBody Priority priority){
        return priorityService.create(priority);


    }

    @PutMapping("/{id}")
    public Priority update(@RequestBody Priority priority, @PathVariable Integer id){
        return priorityService.update(id, priority);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){

        return new ResponseEntity<>("Priority updated successful.", HttpStatus.OK);
    }


}
