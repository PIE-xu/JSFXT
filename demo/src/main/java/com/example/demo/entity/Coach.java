package com.example.demo.entity;

import lombok.Data;

@Data
public class Coach {
    private int id;              // 唯一标识符，主键
    private int gymId;           // 健身房外键
    private String name;         // 教练的姓名
    private String contactInfo;  // 联系信息
    private String qualifications; // 资质

    // 省略构造函数、getter和setter方法
}
