package com.example.demo.controller;

import com.example.demo.entity.Coach;
import com.example.demo.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable String id){
        return coachService.getById(id);
    }

    @PostMapping("/add")
    public boolean addCoach(@RequestBody Coach coach){
        return  coachService.save(coach);
    }

    @DeleteMapping("/delete")
    public boolean deleteCoach(@RequestBody Coach coach){
        return coachService.removeById(coach);
    }

    @PostMapping("/update")
    public boolean updateCoach(@RequestBody Coach coach){
        return coachService.updateById(coach);
    }
}
