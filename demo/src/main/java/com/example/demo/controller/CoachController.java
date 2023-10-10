package com.example.demo.controller;

import com.example.demo.entity.Coach;
import com.example.demo.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable String id){
        return coachService.getById(id);
    }
}
