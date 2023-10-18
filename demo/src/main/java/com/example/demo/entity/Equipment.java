package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Equipment {
    @TableId(type = IdType.AUTO)
    private int id;            // 唯一标识符，主键
    private int gymId;           // 健身房外键
    private String name;       // 健身器材的名称
    private String description;// 健身器材的描述
    private int quantity;      // 数量

    // 省略构造函数、getter和setter方法
}
