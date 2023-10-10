package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.GymClub;
import com.example.demo.entity.User;
import com.example.demo.mapper.GymClubMapper;
import com.example.demo.service.GymClubService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GymClubServiceImpl extends ServiceImpl<GymClubMapper, GymClub> implements GymClubService {

    @Resource
    private GymClubMapper gymClubMapper;

    @Override
    public Page<GymClub> selectPage(Page<GymClub> page, String query) {
        Page<GymClub> list = gymClubMapper.selectPage(page, Wrappers.<GymClub>lambdaQuery().eq(!query.isEmpty(), GymClub::getName,query));
        return list;
    }
}
