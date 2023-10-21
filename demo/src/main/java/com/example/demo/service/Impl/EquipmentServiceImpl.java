package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Equipment;
import com.example.demo.mapper.EquipmentMapper;
import com.example.demo.service.EquipmentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {

    @Resource
    private EquipmentMapper equipmentMapper;
    @Override
    public Equipment getByAdminId( String gymId ){
        return equipmentMapper.selectByadminId(gymId);
    }
}
