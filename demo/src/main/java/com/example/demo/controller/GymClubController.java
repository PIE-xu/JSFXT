package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.GymClub;
import com.example.demo.entity.pageVo;
import com.example.demo.service.GymClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public boolean addGym(@RequestBody GymClub gym){
        return  gymClubService.save(gym);
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
