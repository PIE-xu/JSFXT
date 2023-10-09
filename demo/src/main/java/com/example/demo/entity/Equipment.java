package com.example.demo.entity;

import lombok.Data;

@Data
public class Equipment {
    private int id;            // 唯一标识符，主键
    private String name;       // 健身器材的名称
    private String description;// 健身器材的描述
    private int quantity;      // 数量

    // 省略构造函数、getter和setter方法
}
