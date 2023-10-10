package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.GymClub;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface GymClubService extends IService<GymClub> {

    Page<GymClub> selectPage(Page<GymClub> page, String query);
}
