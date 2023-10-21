package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.Equipment;
import com.example.demo.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/{id}")
    public Equipment getequipmentById(@PathVariable String id){
        return equipmentService.getById(id);
    }

    @GetMapping("admin/{gymId}")
    public List<Equipment> getequipmentByAdminId( @PathVariable String gymId){
        Equipment equipment = new Equipment();
        equipment.setGymId(Integer.parseInt(gymId));
        return equipmentService.list(Wrappers.<Equipment>lambdaQuery().eq(!gymId.isEmpty(), Equipment::getGymId,gymId));
    }

    @PostMapping("/add")
    public boolean addCoach(@RequestBody Equipment equipment){
        return  equipmentService.save(equipment);
    }

    @DeleteMapping("/delete")
    public boolean deleteCoach(@RequestBody Equipment equipment){
        return equipmentService.removeById(equipment);
    }

    @PostMapping("/update")
    public boolean updateCoach(@RequestBody Equipment equipment){
        return equipmentService.updateById(equipment);
    }
}
