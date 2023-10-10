package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GymClub {
    private int id;               // 唯一标识符，主键
    private String name;          // 健身会所或俱乐部的名称
    private String description;   // 健身会所或俱乐部的简介
    private String country;       // 国家
    private String city;          // 城市
    private String streetAddress; // 街道地址
    private String phone;         // 联系电话
    private String businessHours; // 营业时间
    private BigDecimal averageRating; // 用户对健身会所的平均评分
    @TableField(exist = false)
    private Equipment equipment;  // 健身房设备
    @TableField(exist = false)
    private Coach coach;          // 健身房教练
    // 省略构造函数、getter和setter方法
}
