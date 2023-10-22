package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {
    @TableId(type = IdType.AUTO)
    private int id;             // 唯一标识符，主键
    private String username;    // 管理员的用户名
    private String password;    // 管理员的密码，加密存储
    private String name;        // 管理员的真实姓名
    private String email;       // 管理员的电子邮件地址
    private String phone;
    private int managedGym;     // 所管理的健身会所的外键，关联到健身会所信息表的id字段
    @TableField(exist = false)
    private GymClub gymClub;
    // 省略构造函数、getter和setter方法
}
