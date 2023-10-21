package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Equipment;
import org.springframework.stereotype.Service;

@Service
public interface EquipmentService extends IService<Equipment> {
    Equipment getByAdminId( String gymId );
}
