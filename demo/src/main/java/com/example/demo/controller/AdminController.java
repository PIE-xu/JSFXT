package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/login")
    public Admin userLogin( @RequestBody Admin admin){
        Admin admin2 = adminService.getOne(Wrappers.<Admin>lambdaQuery().eq(!admin.getUsername().isEmpty(), Admin::getUsername,admin.getUsername()));
        if(admin.getPassword().equals(admin2.getPassword())){
            return admin2;
        }
        return new Admin();
    }

    @PostMapping("/getAdmin")
    public Admin getAdmin( @RequestBody Admin admin){
        Admin admin2 = adminService.getOne(Wrappers.<Admin>lambdaQuery().eq(!admin.getUsername().isEmpty(), Admin::getUsername,admin.getUsername()));
        return admin2;
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody Admin admin){
        return adminService.save(admin);
    }
}
