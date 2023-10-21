package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.Coach;
import com.example.demo.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable String id){
        return coachService.getById(id);
    }

    @GetMapping("admin/{gymId}")
    public List<Coach> getCoachByAdminId( @PathVariable String gymId){
        Coach coach = new Coach();
        coach.setGymId(Integer.parseInt(gymId));
        return coachService.list(Wrappers.<Coach>lambdaQuery().eq(!gymId.isEmpty(), Coach::getGymId,gymId));
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
