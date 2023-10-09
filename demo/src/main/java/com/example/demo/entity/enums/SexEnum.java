package com.example.demo.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.ToString;

@ToString
public enum SexEnum{
    Male(1, "男"),
    Female(2, "女");


    SexEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }


    private final Integer value;
    @EnumValue
    @JsonValue
    private final String desc;
}
