package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.entity.pageVo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User selectById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("/userList")
    public Page<User> selectPage(pageVo userList){
        System.out.println(userList);
        Page<User> pageList = new Page<>(userList.getPagenum(),userList.getPagesize());
        return userService.selectPage(pageList, userList.getQuery());
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody User user){
        User user1 = userService.getById(user.getName());
        if(user1.getName() != null){
            if(user1.getPassword().equals(user.getPassword())){
                return user1;
            }
        }
        return user;
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody User user){
        user.setPassword("admin123456");
        return userService.save(user);
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody User user){
        return userService.removeById(user);
    }

    @PostMapping("/update")
    public boolean updateUser(@RequestBody User user){
        return userService.updateById(user);
    }



}
