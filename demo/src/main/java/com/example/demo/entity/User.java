package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.demo.entity.enums.SexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@ToString
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String tele;
    private String address;
    private Integer age;
    private SexEnum sex;


}
