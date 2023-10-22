package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Admin;
import com.example.demo.entity.GymClub;
import com.example.demo.entity.GymRequest;
import com.example.demo.entity.pageVo;
import com.example.demo.service.AdminService;
import com.example.demo.service.GymClubService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

/*
*
* 健身房信息管理
*
* */
@RestController
@RequestMapping("/gym")
public class GymClubController {

    @Autowired
    private GymClubService gymClubService;
    @Autowired
    private AdminService adminService;


    /**
    *
    * 显示健身会所或健身俱乐部信息
    * */
    @GetMapping("/gymList")
    public Page<GymClub> selectPage(pageVo gymList){
        Page<GymClub> pageList = new Page<>(gymList.getPagenum(),gymList.getPagesize());
        return gymClubService.selectPage(pageList, gymList.getQuery());
    }

    /**
    *
    * 根据关键字进行搜索查询
    * */
    @GetMapping("/{id}")
    public GymClub selectByName(@PathVariable String id){
        return gymClubService.getById(id);
    }


    @PostMapping("/add")
    public boolean addGym(@RequestBody GymRequest gymRequest){
        System.out.println(gymRequest);
        if(gymClubService.save(gymRequest.getGym())){
         GymClub gym2 = gymClubService.getOne(Wrappers.<GymClub>lambdaQuery().eq(!gymRequest.getGym().getName().isEmpty(), GymClub::getName,gymRequest.getGym().getName()));
         gymRequest.getAdmin().setManagedGym(gym2.getId());
         if(adminService.updateById(gymRequest.getAdmin())){
             return true;
         }
        }
        return  false;
    }

    @DeleteMapping("/delete")
    public boolean deleteGym(@RequestBody GymClub gym){
        return gymClubService.removeById(gym);
    }

    @PostMapping("/update")
    public boolean updateGym(@RequestBody GymClub gym){
        return gymClubService.updateById(gym);
    }
}
